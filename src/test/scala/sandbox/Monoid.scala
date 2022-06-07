package sandbox

import org.scalatest.wordspec.AnyWordSpec
import BooleanMonoidInstances._
import SetMonoidInstances._

// testOnly sandbox.MonoidSpec
class MonoidSpec extends AnyWordSpec {

  // booleanAndMonoid
  println("========== booleanAndMonoid")
  println(booleanAndMonoid.combine(true, true))
  println(booleanAndMonoid.combine(true, false))
  println(booleanAndMonoid.combine(false, true))
  println(booleanAndMonoid.combine(false, false))

  // booleanOrMonoid
  println("========== booleanOrMonoid")
  println(booleanOrMonoid.combine(true, true))
  println(booleanOrMonoid.combine(true, false))
  println(booleanOrMonoid.combine(false, true))
  println(booleanOrMonoid.combine(false, false))

  // booleanEitherMonoid
  println("========== booleanEitherMonoid")
  println(booleanEitherMonoid.combine(true, true))
  println(booleanEitherMonoid.combine(true, false))
  println(booleanEitherMonoid.combine(false, true))
  println(booleanEitherMonoid.combine(false, false))

  // booleanXnorMonoid
  println("========== booleanXnorMonoid")
  println(booleanXnorMonoid.combine(true, true))
  println(booleanXnorMonoid.combine(true, false))
  println(booleanXnorMonoid.combine(false, true))
  println(booleanXnorMonoid.combine(false, false))

  // SetMonoid
  println("========== SetUnionMonoid")
  println(setUnionMonoid.combine(Set(1,2), Set(1,2,3)))
  println(setUnionMonoid.combine(Set("A", "B"), Set("B", "C")))

  // SetSemigroup
  println("========== setIntersectionSemigroup")
  println(setIntersectionSemigroup.combine(Set(1,2,3), Set(1)))
  println(setIntersectionSemigroup.combine(Set("A", "B"), Set("B", "C")))

  // symmetricDiffMonoid
  println("========== symmetricDiffMonoid")
  println(symmetricDiffMonoid.combine(Set(1,2,3), Set(1)))
  println(symmetricDiffMonoid.combine(Set("A", "B"), Set("B", "C")))

}
