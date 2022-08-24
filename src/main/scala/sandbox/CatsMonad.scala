package sandbox

import cats.Monad
import cats.syntax.functor._ // for map
import cats.syntax.flatMap._ // for flatMap

object CatsMonad {

  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] = {
    a.flatMap(x => b.map(y => x * x + y * y))
  }

  /* for内包表記の場合
  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] = {
    for {
      x <- a
      y <- b
    } yield x * x + y * y
  }
  */

}

