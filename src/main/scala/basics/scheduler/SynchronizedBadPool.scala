package basics.scheduler

import scala.collection.mutable

object SynchronizedBadPool{
  private val tasks = mutable.Queue[() => Unit]()

  val worker = new Thread {
    def poll(): Option[() => Unit] = tasks.synchronized {
      if (tasks.nonEmpty) Some(tasks.dequeue()) else None
    }
    override def run() = while (true) poll() match {
      case Some(task) => task()
      case None =>
    } }

  def asynchronous(body: =>Unit) = tasks.synchronized {
    tasks.enqueue(() => body)
  }

  worker.setName("Worker")
  worker.setDaemon(true)
  worker.start()
}
