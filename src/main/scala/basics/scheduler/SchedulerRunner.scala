package basics.scheduler

object SchedulerRunner extends App{

  runBadPool()
  //runGoodPool()
  //runPriorityPool

  def runGoodPool() = {
    SynchronizedWithWaitNotify.asynchronous {
      println("Hello")
    }
    SynchronizedWithWaitNotify.asynchronous {
      println(" world!")
    }
  }

  def runBadPool() = {
    SynchronizedBadPool.asynchronous {
      println("Hello")
    }
    SynchronizedBadPool.asynchronous {
      println(" world!")
    }
  }

    def runPriorityPool() ={
      for (i<- 0 until 10) {
        PriorityPool.asynchronous(println("Hello "+i), i)
      }
    }

    Thread.sleep(30000)

}
