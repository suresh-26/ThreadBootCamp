package basics.uniqueId

object SyncUniqueIdGenerator {
  private var uidCount = 0
  def getUniqueId() = this.synchronized {
    val freshUid = uidCount + 1
    uidCount = freshUid
    freshUid
  }

}
