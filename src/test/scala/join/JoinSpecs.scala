package join

import basics.join.JoinExecutor
import org.scalatest.{FlatSpec, Matchers}

class JoinSpecs extends FlatSpec with Matchers {

  "JoinExecutor" should "execute all threads" in {
    JoinExecutor.executeAllThreads() shouldBe "All threads are dead, exiting main thread"
  }

}
