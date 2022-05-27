package sandbox

import org.scalatest.wordspec.AnyWordSpec
import PrintableInstances._

// testOnly sandbox.PrintableSpec
class PrintableSpec extends AnyWordSpec {

  Printable.format("hogehoge")
  Printable.format(123)
  Printable.print("aaa")
  Printable.print(123)

}
