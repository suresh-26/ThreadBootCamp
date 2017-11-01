package basics.lcisexercise

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import  scala.concurrent.ExecutionContext.Implicits.global
object C1_1 {

  def parallel[A,B](a: =>A, b: =>B, awaitInMillis: Int): (A, B)={
    val futA = Future(a)
    val futB = Future(b)
    val result = for{
      resA <- futA
      resB <- futB
    }yield(resA, resB)

    Await.result(result, awaitInMillis.millis)
  }

}
