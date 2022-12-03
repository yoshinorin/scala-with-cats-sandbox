package sandbox

import cats.FlatMap
import cats.Functor
import cats.implicits._

final case class FlatMapKleisli[F[_], A, B](run: A => F[B]) {
  def compose[Z](k: FlatMapKleisli[F, Z, A])(implicit F: FlatMap[F]): FlatMapKleisli[F, Z, B] =
    FlatMapKleisli[F, Z, B](z => k.run(z).flatMap(run))
}

final case class MapKleisli[F[_], A, B](run: A => F[B]) {
  def map[C](f: B => C)(implicit F: Functor[F]): MapKleisli[F, A, C] =
    MapKleisli[F, A, C](a => F.map(run(a))(f))
}
