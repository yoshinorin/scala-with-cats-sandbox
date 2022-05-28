package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.Eq
import java.util.Date
import cats.instances.int._ // for Eq
import cats.instances.option._ // for Eq
import cats.syntax.option._ // for some and none

// testOnly sandbox.EqExampleSpec
class EqExampleSpec extends AnyWordSpec {

  implicit val eqInt = Eq[Int]
  implicit val someEqInt = Eq[Option[Int]]

  println(eqInt.eqv(123, 123))     // true
  println(eqInt.neqv(123, 999))    // true

  234 === 234

  // Some(1) === None
  // error: value === is not a member of Some[Int]
  // Some(1) === None
  // ^^^^^^^^^^^

  println(Some(1) === Some(2))     // false

  println((Some(1) : Option[Int]) === (None : Option[Int]))  // false
  println(Option(1) ===Option.empty[Int])  // false ↑1行上のものをapplyとemptyで書いたもの

  1.some === none[Int]
  // 1.some =!= none[Int]

  val x = new Date() // now
  val y = new Date() // a bit later than now

  x === x
  // res12: Boolean = true
  x === y
  // res13: Boolean = false

  val tama = Cat("Tama", 6, "Black")
  val pochi = Cat("Pochi", 7, "White")
  val tama2 = Cat("Tama", 6, "Black")

  println(tama === tama) // true
  println(tama === tama2) //true
}
