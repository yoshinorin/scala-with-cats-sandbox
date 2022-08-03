package sandbox

import org.scalatest.wordspec.AnyWordSpec
import MyCodec._

// testOnly sandbox.MyCodecSpec
class MyCodecSpec extends AnyWordSpec {

  val v1 = encode(123.4)
  println(v1)

  val v2 = decode[Double]("123.4")
  println(v2)

  val v3 = encode(Box(123.4))
  println(v3)

  val v4 = decode[Box[Double]]("123.4")
  println(v4)
}
