package np.santa

import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import np.santa.ChristmasShop.StartChristmasShopMsg
import np.santa.actors.Santa
import np.santa.actors.Santa.SantaWakeupCall


// This starts the program
object ChristmasShopMain extends App {
  val christmasShop = ActorSystem(ChristmasShop(), "christmasShop")
  christmasShop ! StartChristmasShopMsg()
}

// companion object for root actor called 'ChristmasShop'
object ChristmasShop {

  def apply(): Behavior[ChristmasShopMessage] =
    Behaviors.setup(context => new ChristmasShop(context))

  final case class StartChristmasShopMsg() extends ChristmasShopMessage

}

// root actor implementation
class ChristmasShop(context: ActorContext[ChristmasShopMessage]) extends AbstractBehavior[ChristmasShopMessage](context) {

  val santa: ActorRef[ChristmasShopMessage] = context.spawn(Santa(), "SantaClause")

  override def onMessage(msg: ChristmasShopMessage): Behavior[ChristmasShopMessage] =
    msg match {
      case StartChristmasShopMsg() =>
        context.log.info("The Christmas Shop starts its preparation for this year's Christmas.")

        context.log.info("The shop staff sends a wakeup message to Santa...")
        santa ! SantaWakeupCall()

        this
    }
}




