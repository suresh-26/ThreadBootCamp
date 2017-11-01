package basics.deadlock

import basics.nested.sync.Account

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object DeadlockRunner extends App{

  val a = new Account("Jack", 1000)
  val b = new Account("Jill", 2000)
  val t1 =  Future { for (i<- 0 until 100) yield SyncDeadlockFree.deadLockFreeSend(a, b, 1)}
  val t2 =  Future { for (i<- 0 until 100) yield SyncDeadlockFree.deadLockFreeSend(b, a, 1)}
  Await.result(t1, 2.minutes)
  Await.result(t2, 2.minutes)
  //t1.join()
  //t2.join()
  println(s"a = ${a.money}, b = ${b.money}")


  def thread(body: => Unit) ={
   val t = new Thread{
     override def run(): Unit = body
   }
    t.start()
    t
  }
}
