package sandbox

import cats.MonadError
import cats.syntax.applicative._      // for pure
import cats.syntax.applicativeError._ // for raiseError etc

object CatsEither {

  type ExceptionOr[A] = Either[Throwable, A]

  def validateAdult[F[_]](age: Int)(implicit me: MonadError[F, Throwable]): F[Int] = {
    if(age >= 18) age.pure[F]
    else new IllegalArgumentException("Age must be greater than or equal to 18").raiseError[F, Int]
  }
}
