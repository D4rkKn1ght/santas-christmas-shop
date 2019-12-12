package np.santa.actors

import akka.actor.testkit.typed.scaladsl.{BehaviorTestKit, ScalaTestWithActorTestKit}
import np.santa.ChristmasShopMessage
import org.junit.runner.RunWith
import org.scalatest.WordSpecLike
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SantaSpec extends ScalaTestWithActorTestKit with WordSpecLike {
  "Santa" must {
    "ask for Nice-list on Wakeup call " in {
      val santaTestKit = BehaviorTestKit(Santa())

      santaTestKit.run(Santa.SantaWakeupCall())

      val bernardInbox = santaTestKit.childInbox[ChristmasShopMessage]("Bernards Present Management")
      bernardInbox.expectMessage(BernardsPresentManagement.GetNiceList(santaTestKit.ref))
    }

  }
}
