package basics.nested.sync

object SynchronizedNesting {

  import scala.collection._

  private val transfers = mutable.ArrayBuffer[String]()

  def logTransfer(name: String, n: Int) = transfers.synchronized {
    transfers += s"transfer to account '$name' = $n"
  }
}