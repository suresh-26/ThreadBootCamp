package basics.deadlock

import basics.nested.sync.Account
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object SendAllRunner extends App {

  val nos1 = 1 until 100 toSet
  val accs1 = nos1.map(createAccount)

  val nos2 = 1 until 33 toSet
  val accs2 = nos2.map(createAccount)

  val nos3 = 33 until 66 toSet
  val accs3 = nos3.map(createAccount)

  val nos4 = 66 until 100 toSet
  val accs4 = nos4.map(createAccount)

  val target = createAccount(1001)


  val t1 = Future {
    SynchronizedSendAll.sendAll(accs1, target)
  }
  val t2 = Future {
    SynchronizedSendAll.sendAll(accs2, accs1.toList(30))
  }
  val t3 = Future {
    SynchronizedSendAll.sendAll(accs3, accs2.toList(30))
  }
  val t4 = Future {
    SynchronizedSendAll.sendAll(accs4, target)
  }

  val result = for{
    res1 <- t1
    res2 <- t2
    res3 <- t3
    res4 <- t4
  }yield(res1, res2, res3, res4)

  Await.result(result, 5.minutes)

  accs1.foreach(println)
  accs2.foreach(println)
  accs3.foreach(println)
  accs4.foreach(println)
  //Thread.sleep(5000)
  println("target : "+target)
  println("target2: "+accs1.toList(30))
  println("target2: "+accs2.toList(30))
  println("total size: "+(accs1.size+accs2.size+accs3.size+accs4.size+1))
  def createAccount(no: Int): Account = {
    Account("acc" + no, 100)
  }
}
