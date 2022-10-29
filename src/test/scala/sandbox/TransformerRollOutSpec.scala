package sandbox

import org.scalatest.wordspec.AnyWordSpec
import TransformerRollOut._

// testOnly sandbox.TransformerRollOutSpec
class TransformerRollOutSpec extends AnyWordSpec {
  println(tacticalReport("Jazz", "Bumblebee"))
  println(tacticalReport("Bumblebee", "Hot Rod"))
  println(tacticalReport("Jazz", "Ironhide"))
}
