package np.santa.actors

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import np.santa.ChristmasShopMessage
import np.santa.actors.Santa.SantaWakeupCall

object Santa {
  def apply(): Behavior[ChristmasShopMessage] =
    Behaviors.setup(context => new Santa(context))

  final case class SantaWakeupCall() extends ChristmasShopMessage
}



class Santa(context: ActorContext[ChristmasShopMessage])  extends AbstractBehavior[ChristmasShopMessage](context) {

  override def onMessage(msg: ChristmasShopMessage): Behavior[ChristmasShopMessage] =
    msg match {
      case SantaWakeupCall() =>
        context.log.info("Santa wakes up. 'Good morning my dear elves!'")
        this
    }
}
