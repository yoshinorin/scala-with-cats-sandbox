package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.data.Reader
import sandbox.CatsReader._

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

  val feedKitty: Reader[Cat, String] = Reader(cat => s"Have a nice bowl of ${cat.favoriteFood}")

  val greetAndFeed: Reader[Cat, String] = {
    for {
      greet <- greetKitty
      feed <- feedKitty
    } yield s"$greet. $feed"
  }

  println(greetAndFeed(Cat("Garfield", "lasagne")))

  val users = Map(
    1 -> "dade",
    2 -> "kate",
    3 -> "margo"
  )

  val passwords = Map(
    "dade"  -> "zerocool",
    "kate"  -> "acidburn",
    "margo" -> "secret"
  )

  val db = Db(users, passwords)
  println(checkLogin(1, "zerocool").run(db))
  println(checkLogin(4, "davinci").run(db))
}
