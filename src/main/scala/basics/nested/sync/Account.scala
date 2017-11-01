package basics.nested.sync

import basics.uniqueId.SyncUniqueIdGenerator

case class Account(name: String, @volatile var money: Int){
  val uid = SyncUniqueIdGenerator.getUniqueId()
}



