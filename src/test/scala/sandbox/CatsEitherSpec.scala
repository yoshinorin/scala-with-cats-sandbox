package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.syntax.either._ // for asRight

// testOnly sandbox.CatsEitherSpec
class CatsEitherSpec extends AnyWordSpec {

  // right と left を生成できる
  val a = 3.asRight[String]
  val b = 4.asRight[String]
  val c = 5.asLeft[String]

  for {
    x <- a
    y <- b
    // z <- c  `c` は `Left` なので ここではつかえない
  } yield x * x + y * y

  Either.catchOnly[NumberFormatException]("foo".toInt)
  Either.catchNonFatal(sys.error("Badness"))
  Either.fromTry(scala.util.Try("foo".toInt))
  Either.fromOption[String, Int](None, "Badness")

  -1.asRight[String].ensure("Must be non-negative!")(_ > 0)

  "error".asLeft[Int].recover {
    case _: String => -1
  }

  "error".asLeft[Int].recoverWith {
    case _: String => Right(-1)
  }

  "foo".asLeft[Int].leftMap(_.reverse)
  6.asRight[String].bimap(_.reverse, _ * 7)
  "bar".asLeft[String].bimap(_.reverse, _ * 7)

  123.asRight[String].swap
  123.asLeft[String].swap

  for {
    a <- 1.asRight[String]
    b <- 0.asRight[String]
    c <- if (b == 0) "DIV0".asLeft[Int]
         else (a / b).asRight[String]
  } yield c * 100
}
