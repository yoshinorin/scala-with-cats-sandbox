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

}
