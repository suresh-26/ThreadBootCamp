package basics.deadlock

import basics.nested.sync.Account

object SynchronizedDeadlock {
  def send(a: Account, b: Account, n: Int) = a.synchronized {
    b.synchronized {
      a.money -= n
      b.money += n
    }
  }
}
