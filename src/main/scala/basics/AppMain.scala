package basics

import scala.annotation.tailrec

object AppMain extends App{


  def getSeqWithRec(num: Int): Int = {
    num match {
      case 1 => num
      case num if num % 2 == 0 => num + getSeqWithRec(num / 2)
      case _ => num + getSeqWithRec(num * 3 + 1)
    }
  }

  getSeqWithRec(5)
}
