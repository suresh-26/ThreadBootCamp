package basics.lcisexercise

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class C1_4 {

  def produce(): Seq[Future[Int]] = {
    for (i <- 1 to 15)
      yield {
        Future {
          Thread.sleep(1000)
          println(i)
          i
        }
      }
  }

}
