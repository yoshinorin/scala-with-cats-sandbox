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

  val cat = Cat("Tama", 6, "Black")
  Printable.print(cat)

  cat.print
}
