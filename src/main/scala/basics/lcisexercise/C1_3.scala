package basics.lcisexercise

import scala.util.{Failure, Success, Try}

class C1_3[T] {

  var syncVar: Option[T] = None
  private var isEmptyByGet = false

  def get(): T = {
    Try(syncVar.get) match {
      case Success(v) => syncVar = None
                      isEmptyByGet = true
                          v
      case Failure(e) => throw e
    }
  }

  def put(x: T): Unit = {
    if(isEmptyByGet) throw new RuntimeException("suncVar is empty")
    syncVar = Some(x)
  }

  def isEmpty = syncVar.isEmpty

  def nonEmpty = syncVar.isDefined
}
