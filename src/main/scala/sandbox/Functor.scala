package sandbox

import cats.Functor
import scala.concurrent.{Future, ExecutionContext}

object Functors {

  implicit val optionFunctor: Functor[Option] =
    new Functor[Option] {
      def map[A, B](value: Option[A])(func: A => B): Option[B] =
        // Optionのmapを呼ぶだけ（value.mapの部分）
        value.map(func)
    }

  implicit def futureFunctor(implicit ec: ExecutionContext): Functor[Future] =
    new Functor[Future] {
      def map[A, B](value: Future[A])(func: A => B): Future[B] = value.map(func)
    }

}
