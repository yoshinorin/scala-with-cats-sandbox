package sandbox

import org.scalatest.wordspec.AnyWordSpec
import PrintableInstances._
import PrintableSyntax._

// testOnly sandbox.PrintableSpec
class PrintableSpec extends AnyWordSpec {

  Printable.format("hogehoge")
  Printable.format(123)
  Printable.print("aaa")
  Printable.print(123)
  Printable.print(true)
  Printable.print(false)

  // contramap
  val b1 = Printable.format(Box("Hello World"))
  val b2 = Printable.format(Box(true))
  println(b1)
  println(b2)

  val cat = Cat("Tama", 6, "Black")
  Printable.print(cat)

  cat.print
}
