package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.Monoid
import cats.instances.string._  // for Monoid
import cats.instances.int._ // for Monoid
import cats.instances.option._ // for Monoid
import cats.Semigroup
import cats.syntax.semigroup._ // for |+|

// testOnly sandbox.CatsMonoidSpec
class CatsMonoidSpec extends AnyWordSpec {

  Monoid[String].combine("Hi", "there")
  Monoid.apply[String].combine("Hi", "there") // 同じ

  Semigroup[String].combine("Hi ", "there") // empty不要の場合は半群でOK

  Monoid[String].empty
  Monoid.apply[String].empty // 同じ

  Monoid[Int].combine(32, 10)

  val a = Option(22)
  val b = Option(20)

  Monoid[Option[Int]].combine(a, b)

  val stringResult = "Hi " |+| "there" |+| Monoid[String].empty
  val intResult = 1 |+| 2 |+| Monoid[Int].empty

  superAdder.add(List(1, 2))
  superAdder.add(List(Some(1), None, Some(2), None, Some(3)))

  // superAdder.add(List(Some(1), Some(2), Some(3)))
  // エラーとなる
  // could not find implicit value for parameter monoid: cats.Monoid[Some[Int]]

}
