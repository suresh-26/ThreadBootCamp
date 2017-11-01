package basics.util

object Wait {

  def execute(waitTime: Int): Int = {
      System.out.println("Thread started:::" + Thread.currentThread().getName())
      Thread.sleep(waitTime)
      System.out.println("Thread ended:::" + Thread.currentThread().getName())
    waitTime
  }
}
