package sandbox

import org.scalatest.wordspec.AnyWordSpec
import java.util.Date
import cats.Show
import cats.instances.int._    // for Show
import cats.instances.string._ // for Show
import cats.syntax.show._      // for Show
import sandbox.catsShow._

// testOnly sandbox.CatsShowSpec
class CatsShowSpec extends AnyWordSpec {
  val showInt:    Show[Int]    = Show.apply[Int]
  val showString: Show[String] = Show.apply[String]

  val intAsString: String = showInt.show(123)
  println(intAsString)

  val stringAsString: String = showString.show("abc")
  println(stringAsString)

  val showInt2 = 123.show
  val showString2 = "abc".show

  val d = new Date().show
  println(d)

  val cat = Cat("Nyao", 9, "White")
  println(cat.show)
}
