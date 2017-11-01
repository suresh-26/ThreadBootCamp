package lcisexercise

import basics.lcisexercise.C1_1
import basics.util.Wait
import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.TimeoutException

class C1_1Specs extends FlatSpec with Matchers {

  "C1_1" should "execute all blocks in parallel with total time equals block taking longest time to execute" in {
    val startTime = System.currentTimeMillis
    val result  = C1_1.parallel[Int, Int](Wait.execute(4000), Wait.execute(4500), 4500)
    val elapsed = System.currentTimeMillis - startTime
    elapsed should be < 5000L
  }

  "C1_1" should "fails when await timeout is lesser than the block requires longest exection time" in {

    an [TimeoutException] should be thrownBy C1_1.parallel[Int, Int](Wait.execute(4000), Wait.execute(6000), 5000)

  }

}