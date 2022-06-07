package sandbox

import org.scalatest.wordspec.AnyWordSpec
import BooleanMonoidInstances._

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
}
