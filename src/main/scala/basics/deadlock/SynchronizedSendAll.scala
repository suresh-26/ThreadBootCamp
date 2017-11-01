package basics.deadlock

import basics.nested.sync.Account

object SynchronizedSendAll {

  def sendAll(accounts: Set[Account], target: Account): Unit = {
    println("invoke send all for target: "+ target+ " ans source accs : "+accounts.size)
    accounts.foreach { acc =>
      target.synchronized {
        Thread.sleep(50)
        target.money += acc.money
        acc.money = 0
      }
    }
  }
}
