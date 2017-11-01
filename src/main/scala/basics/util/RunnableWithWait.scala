package basics.util

class RunnableWithWait extends Runnable {
  override def run(): Unit = {
    System.out.println("Thread started:::" + Thread.currentThread().getName())
    Thread.sleep(4000)
    System.out.println("Thread ended:::" + Thread.currentThread().getName())
  }
}

