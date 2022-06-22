package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.Functor
import CatsFunctor._

// testOnly sandbox.CatsFunctorSpec
class CatsFunctorSpec extends AnyWordSpec {

  println(list1)
  println(list2)

  println(option1)
  println(option2)

  println("=========== before lift")
  println(func)
  println("=========== after lift")
  println(liftedFunc(Option(1)))

  println("============ as")
  println(Functor[List].as(list1, "As"))

  println("============ Function1 map")
  println(func4(123))

  println("=========== doMath")
  // println(doMath(20))
  println(doMath(Option(120)))
  println(doMath(List(1,2,4,8)))

}
