package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.data.Reader

final case class Cat(name: String, favoriteFood: String)

// testOnly sandbox.CatsReaderSpec
class CatsReaderSpec extends AnyWordSpec {
  val catName: Reader[Cat, String] = Reader(cat => cat.name)
  println(catName)  // Kleisli(sandbox.CatsReaderSpec$$Lambda$6544/0x0000000801e4c190@4d05f1ec)

  val cat2 = catName.run(Cat("Garfield", "lasagne"))
  println(cat2)  // Garfield

  val greetKitty: Reader[Cat, String] = catName.map(name => s"Hello ${name}")
  val gk = greetKitty.run(Cat("Hathcliff", "junk food"))
  println(gk)
}
