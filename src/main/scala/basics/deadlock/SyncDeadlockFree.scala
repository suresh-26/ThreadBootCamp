package basics.deadlock

import basics.nested.sync.Account

object SyncDeadlockFree {
  def deadLockFreeSend(a1: Account, a2: Account, n: Int) {
    def adjust() {
      a1.money -= n
      a2.money += n
    }
    if (a1.uid < a2.uid) {
      println("locking a1: "+a1.name + " uid: "+a1.uid)
      a1.synchronized {
        println("locking nested a2: "+ a2.name + " uid: "+a2.uid)
        a2.synchronized {
          adjust()
        }
        println("releasing nested a2 "+a2.name +  " uid: "+a2.uid)
      }
    }
    else {
      println("locking a2 : "+a2.name + " uid: "+a2.uid)
      a2.synchronized {
        println("locking nested a1 "+a1.name + " uid: "+a1.uid)
        a1.synchronized {
          adjust()
        }
      }
      println("releasing nested a1 "+a1.name + " uid: "+a1.uid)
    }
  }
}
