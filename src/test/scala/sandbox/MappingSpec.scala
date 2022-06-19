package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.instances.function._ // for Functor
import cats.syntax.functor._     // for map
import Mapping._

// testOnly sandbox.MappingSpec
class MappingSpec extends AnyWordSpec {

  (func1 map func2)(1)
  (func1 andThen func2)(1)
  func2(func1(1))

}
