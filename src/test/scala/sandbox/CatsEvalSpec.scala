package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.Eval
import sandbox.CatsEval._

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

  val y = Eval.always{
    println("Computing Y")
    math.random()
  }
  y.value
  y.value

  val z = Eval.later{
    println("Computing Z")
    math.random()
  }
  z.value
  z.value

  val greeting = Eval
    .always{ println("Step 1"); "Hello" }
    .map{ str => println("Step 2"); s"$str world" }

  greeting.value

  val ans = for {
    a <- Eval.now{ println("Calculating A"); 40 }
    b <- Eval.always{ println("Calculating B"); 2 }
  } yield {
    println("Adding A and B")
    a + b
  }
  ans.value
  ans.value

  val saying = Eval
    .always{ println("Step 1"); "The cat" }
    .map{ str => println("Step 2"); s"$str sat on" }
    .memoize
    .map{ str => println("Step 3"); s"$str the mat" }

  saying.value
  saying.value

  // スタックセーフ！！！！ではない...
  // println(unStackSafefactorial(50000).value)
  // スタックセーフ
  println(stackSafeFactorial(50000).value)

  println(stackSafeFoldRight((1 to 100000).toList, Eval.now(0L))(_))
  println(foldRight((1 to 100000).toList, 0L)(_ + _))
}
