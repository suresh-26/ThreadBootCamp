package lcisexercise

import basics.lcisexercise.C1_4
import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class C1_4Specs extends FlatSpec with Matchers {

  val c1_4 = new C1_4()

  "c1_4 produce" should "create 15 threads to consume and should take less than 15 secs to process" in {
    val startTime = System.currentTimeMillis()
    val futures = c1_4.produce()
    val aggregatedFutures = Future.sequence(futures)
    val result = Await.result(aggregatedFutures, 12.seconds)
    val elapsed = System.currentTimeMillis() - startTime
    elapsed should be < 10000L
    result shouldBe Vector(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
  }

}
