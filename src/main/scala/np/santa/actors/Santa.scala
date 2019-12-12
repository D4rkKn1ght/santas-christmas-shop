package np.santa.actors

import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import akka.actor.typed.{ActorRef, Behavior}
import np.santa.ChristmasShopMessage
import np.santa.actors.Santa.SantaWakeupCall

object Santa {
  def apply(): Behavior[ChristmasShopMessage] =
    Behaviors.setup(context => new Santa(context, context.spawn(BernardsPresentManagement(), "Bernards Present Management")))

  final case class SantaWakeupCall() extends ChristmasShopMessage
  final case class ProvideNiceList(niceList: List[String]) extends ChristmasShopMessage

}

class Santa(context: ActorContext[ChristmasShopMessage], bernardsPresentManagement: ActorRef[ChristmasShopMessage]) extends AbstractBehavior[ChristmasShopMessage](context) {

  override def onMessage(msg: ChristmasShopMessage): Behavior[ChristmasShopMessage] =
    msg match {
      case SantaWakeupCall() =>
        context.log.info("Santa wakes up. 'Good morning my dear elves!'")
        // TODO get the Nice-List (List of String) from Bernard

        Behaviors.same

        // TODO finally get the list and print it here

      case _ =>
        context.log.info("Cannot process message!")

        Behaviors.same

    }
}
