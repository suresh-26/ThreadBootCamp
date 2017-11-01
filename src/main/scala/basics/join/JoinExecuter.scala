package basics.join

import basics.util.RunnableWithWait

object JoinExecutor{

  def executeAllThreads(): String = {
    val t1 = new Thread(new RunnableWithWait(), "t1")
    val t2 = new Thread(new RunnableWithWait(), "t2")
    val t3 = new Thread(new RunnableWithWait(), "t3")

    t1.start()
    //start second thread after waiting for 2 seconds or if it's dead
    t1.join(2000)
    t2.start()
    //start third thread only when first thread is dead
    t1.join()
    t3.start()

    //let all threads finish execution before finishing main thread
    t1.join()
    t2.join()
    t3.join()

    "All threads are dead, exiting main thread"
  }
}
