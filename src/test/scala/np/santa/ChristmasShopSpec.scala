package np.santa

import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit
import np.santa.ChristmasShop.StartChristmasShopMsg
import np.santa.actors.Santa.SantaWakeupCall
import org.junit.runner.RunWith
import org.scalatest.WordSpecLike
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ChristmasShopSpec extends ScalaTestWithActorTestKit with WordSpecLike {
  "Santa" must {
    "wake up" in {
      val christmasShop = testKit.spawn(ChristmasShop(), "testChristmasShop")
      val santaTestProbe = testKit.createTestProbe[SantaWakeupCall]()
      christmasShop ! StartChristmasShopMsg()
      //santaTestProbe.expectMessage(StartChristmasShopMsg)
    }
  }
}

