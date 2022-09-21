package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.Eval

// testOnly sandbox.CatsEvalSpec
class CatsEvalSpec extends AnyWordSpec {

  val now = Eval.now(math.random() + 1000)
  println(now)
  val always = Eval.always(math.random() + 1000)
  println(always)
  val later = Eval.later(math.random() + 1000)
  println(later)

  println(now.value)
  println(always.value)
  println(later.value)

  val x = Eval.now{
    println("Computing X")
    math.random()
  }
  // x Now(0.681816469770503) .value で値を抽出せずとも評価される
  x.value
  x.value
}
