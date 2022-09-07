package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.MonadError
import cats.instances.either._

// testOnly sandbox.CatsMonadErrorSpec
class CatsMonadErrorSpec extends AnyWordSpec {

  type ErrorOr[A] = Either[String, A]
  val monadError = MonadError[ErrorOr, String]

  val success = monadError.pure(42)
  val failure = monadError.raiseError("Badness")

  monadError.handleErrorWith(failure) {
    case "Badness" =>
      monadError.pure("It's ok")
    case _ =>
      monadError.raiseError("It's not ok")
  }

  monadError.handleError(failure) {
    case "Badness" => 42
  }

}
