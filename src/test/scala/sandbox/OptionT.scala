package sandbox

import cats.data.OptionT
import cats.instances.list._     // for Monad
import cats.syntax.applicative._ // for pure
import org.scalatest.wordspec.AnyWordSpec

// testOnly sandbox.OptionTSpec
class OptionTSpec extends AnyWordSpec {

  type ListOption[A] = OptionT[List, A]

  val result1: ListOption[Int] = OptionT(List(Option(10)))
  println(result1)

  val result2: ListOption[Int] = 32.pure[ListOption]
  println(result2)

  result1.flatMap { (x: Int) =>
    result2.map { (y: Int) =>
      println(x + y)
    }
  }

  for {
    x <- result1
    y <- result2
  } yield println(x + y)

  for {
    x <- List(Some(1))
    y <- List(Some(2))
  } yield println(x.get + y.get)

  for {
    x <- OptionT(List(Option(1)))
    y <- OptionT(List(Option(2)))
  } yield println(x + y)

}
