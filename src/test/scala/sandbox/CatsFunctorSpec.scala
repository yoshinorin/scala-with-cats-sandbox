package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.Functor
import CatsFunctor._
import cats.Show
import cats.Monoid
import cats.syntax.contravariant._ // for contramap
import cats.instances.string._ // for Monoid
import cats.syntax.invariant._ // for imap
import cats.syntax.semigroup._ // for |+|

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

  println("============ contramap")
  val showString = Show[String]
  val showSymbol = cats.Contravariant[Show].contramap(showString)((sym: Symbol) => s"'${sym.name}")
  println(showSymbol.show(Symbol("dave")))

  showString.contramap[Symbol](sym => s"'${sym.name}").show(Symbol("dave"))

  implicit val symbolMonoid: Monoid[Symbol] = Monoid[String].imap(Symbol.apply)(_.name)

  Monoid[Symbol].empty
  // res3: Symbol = '

  Symbol("a") |+| Symbol("few") |+| Symbol("words")
  // res4: Symbol = 'afewwords
}
