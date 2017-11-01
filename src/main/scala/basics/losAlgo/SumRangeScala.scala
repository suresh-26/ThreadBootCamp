package basics.losAlgo

import java.util
import java.util.Arrays

import scala.collection.mutable.ListBuffer
import scala.collection.JavaConverters._

object SumRangeScala {



  private def sum_up_recursive(numbers: ListBuffer[Int], target: Int, partial: ListBuffer[Int], result: ListBuffer[ListBuffer[Int]]): ListBuffer[ListBuffer[Int]] = {
    var s: Int = 0
    for (x <- partial) s += x
    if (s == target) result += partial
    if (s >= target) return result
    var i: Int = 0
    while (i < numbers.size) {
      {
        val remaining = new ListBuffer[Int]
        val n: Int = numbers(i)
        var j: Int = i + 1
        while (j < numbers.size) {
          remaining += numbers(j)
          j += 1; j - 1
        }
        val partial_rec = partial
        partial_rec += n
        sum_up_recursive(remaining, target, partial_rec, result)
      }
      {
        i += 1; i - 1
      }
    }
    result
  }

  def sum_up(numbers: List[Int], target: Int): ListBuffer[ListBuffer[Int]] = {
    val nosAsBuffer = new ListBuffer[Int]
    numbers.foreach(x => nosAsBuffer+=x)
    sum_up_recursive(nosAsBuffer, target, new ListBuffer[Int], new ListBuffer[ListBuffer[Int]])
  }



}
