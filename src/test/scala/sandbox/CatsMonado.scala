package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.Monad
import cats.instances.option._ // for Monad
import cats.instances.list._   // for Monad
import scala.concurrent.ExecutionContext.Implicits.global // futureモナド向け
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration

// testOnly sandbox.CatsMonadSpec
class CatsMonadSpec extends AnyWordSpec {

  val opt1 = Monad[Option].pure(3)
  val opt2 = Monad[Option].flatMap(opt1)(a => Some(a + 2))
  val opt3 = Monad[Option].map(opt2)(a => 100 * a)

  val list1 = Monad[List].pure(3)
  val list2 = Monad[List].flatMap(List(1,2,3))(a => List(a, a * 10))
  val list3 = Monad[List].map(list2)(a => a + 123)

  // Futureモナド
  val fm = Monad[Future]
  val future = fm.flatMap(fm.pure(1))(x => fm.pure(x + 2))
  Await.result(future, Duration.Inf)

}
