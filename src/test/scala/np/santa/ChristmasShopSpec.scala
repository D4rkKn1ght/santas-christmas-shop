package np.santa

import akka.actor.testkit.typed.scaladsl.BehaviorTestKit
import np.santa.actors.Santa.SantaWakeupCall
import org.junit.runner.RunWith
import org.scalatest.WordSpecLike
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ChristmasShopSpec extends WordSpecLike {
  "Santa" must {
    "wake up when shop is created" in {
      val shopTestKit = BehaviorTestKit(ChristmasShop())

      shopTestKit.run(ChristmasShop.StartChristmasShopMsg())

      val santaInbox = shopTestKit.childInbox[ChristmasShopMessage]("SantaClause")
      santaInbox.expectMessage(SantaWakeupCall())
    }
  }
}

