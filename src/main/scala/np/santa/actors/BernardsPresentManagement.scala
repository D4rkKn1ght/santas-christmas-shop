package np.santa.actors

import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import akka.actor.typed.{ActorRef, Behavior}
import np.santa.ChristmasShopMessage
import np.santa.actors.BernardsPresentManagement.GetNiceList
import np.santa.actors.Santa.ProvideNiceList

object BernardsPresentManagement {
  def apply(): Behavior[ChristmasShopMessage] =
    Behaviors.setup(context => new BernardsPresentManagement(context))

  final case class GetNiceList(santa: ActorRef[ChristmasShopMessage]) extends ChristmasShopMessage

}

class BernardsPresentManagement(context: ActorContext[ChristmasShopMessage]) extends AbstractBehavior[ChristmasShopMessage](context) {

  override def onMessage(msg: ChristmasShopMessage): Behavior[ChristmasShopMessage] =
    msg match {
      // TODO here is where Bernard responds
      case GetNiceList(santa) =>
        santa ! ProvideNiceList(List("Simone", "Hannes"))
        Behaviors.same
    }
}
