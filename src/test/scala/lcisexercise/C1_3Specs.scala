package lcisexercise

import basics.lcisexercise.C1_3
import org.scalatest.{FlatSpec, Matchers}


class C1_3Specs extends FlatSpec with Matchers {

  val c1_3 = new C1_3[String]()

  "C1_3 get" should "throw Exception when syncVar is empty" in {
    an [NoSuchElementException] should be thrownBy c1_3.get
  }

  "c1_3 put" should "assign value to syncVar" in {
    c1_3.put("first val")
    c1_3.syncVar shouldBe  Some("first val")
  }

  "c1_3 get" should "return syncVar make it empty" in {
    c1_3.get() shouldBe "first val"
    c1_3.syncVar shouldBe  None
  }

  "c1_3 put" should "throw exception when get has already marked syncvar empty" in {
    an [RuntimeException] should be thrownBy c1_3.put("new val")
  }


}
