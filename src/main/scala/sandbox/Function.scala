package sandbox

trait Function1[-A, +B] {
  def apply(arg: A): B
}

trait MyFunctor[F[_]] {
  def map[A, B](fa: F[A])(func: A => B): F[B]
}

