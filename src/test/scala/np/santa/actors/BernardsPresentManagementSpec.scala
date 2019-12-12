package np.santa.actors

import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit
import np.santa.ChristmasShopMessage
import np.santa.actors.BernardsPresentManagement.GetNiceList
import np.santa.actors.Santa.ProvideNiceList
import org.junit.runner.RunWith
import org.scalatest.WordSpecLike
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BernardsPresentManagementSpec extends ScalaTestWithActorTestKit with WordSpecLike {
  "Bernard" must {
    "return nice list when receiving a getNiceList message" in {
      val bernard = testKit.spawn(BernardsPresentManagement(), "bernard")
      val probe = testKit.createTestProbe[ChristmasShopMessage]()
      bernard ! GetNiceList(probe.ref)
      probe.expectMessage(ProvideNiceList(List("Simone", "Hannes")))
    }
  }
}
