package np.santa.actors

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}
import np.santa.ChristmasShopMessage


object CharliesSweetsFactory {
  def apply(): Behavior[ChristmasShopMessage] =
    Behaviors.setup(context => new CharliesSweetsFactory(context)
  )
}

class CharliesSweetsFactory(context: ActorContext[ChristmasShopMessage]) extends AbstractBehavior[ChristmasShopMessage](context) {
  override def onMessage(msg: ChristmasShopMessage): Behavior[ChristmasShopMessage] = Behaviors.same
}
