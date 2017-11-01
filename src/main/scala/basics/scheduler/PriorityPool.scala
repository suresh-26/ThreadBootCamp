package basics.scheduler


import scala.collection.mutable

object PriorityPool {
  private var priorityTasks = scala.collection.mutable.PriorityQueue[(() => Unit, Int)]()(Ordering.by(order))

  object Worker extends Thread {
    setDaemon(true)

    def poll() = priorityTasks.synchronized {
      while (priorityTasks.isEmpty) priorityTasks.wait()
      priorityTasks.dequeue()
    }

    override def run() = while (true) {
      val task: (() => Unit, Int) = poll()
      task._1()
      Thread.sleep(500)
    }
  }

  Worker.start()

  def order(task: (()=>Unit, Int)) = task._2
  def asynchronous(body: =>Unit, priority: Int) = priorityTasks.synchronized {
    priorityTasks += (() => body, priority)
    priorityTasks.notify()
  }

}
