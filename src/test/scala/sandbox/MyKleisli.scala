package sandbox

import org.scalatest.wordspec.AnyWordSpec

// testOnly sandbox.Kleisli
class MyKleisli extends AnyWordSpec {

  val twice: Int => Int = x => x * 2
  val countCats: Int => String =
    x => if (x == 1) "1 cat" else s"$x cats"

  // 普通の関数合成
  val twiceAsManyCats: Int => String =
    twice andThen countCats

  println(twiceAsManyCats(1))

  // parse と reciprocal は通常は合成できない
  val parse: String => Option[Int] =
    s => if (s.matches("-?[0-9]+")) Some(s.toInt) else None

  val reciprocal: Int => Option[Double] =
    i => if (i != 0) Some(1.0 / i) else None

  val parseFK: FlatMapKleisli[Option,String,Int] =
    FlatMapKleisli((s: String) => if (s.matches("-?[0-9]+")) Some(s.toInt) else None)

  val reciprocalFK: FlatMapKleisli[Option, Int, Double] =
    FlatMapKleisli((i: Int) => if (i != 0) Some(1.0 / i) else None)

  val parseAndReciprocal: FlatMapKleisli[Option, String, Double] =
    reciprocalFK.compose(parseFK)
}
