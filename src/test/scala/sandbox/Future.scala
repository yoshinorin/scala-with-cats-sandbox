package sandbox

import org.scalatest.wordspec.AnyWordSpec
import scala.concurrent.Await
import scala.concurrent.duration._

// testOnly sandbox.FutureSpec
class FutureSpec extends AnyWordSpec {

  val result1 = Await.result(FutureSandbox.future1, 1.second)
  val result2 = Await.result(FutureSandbox.future2, 1.second)

  println(result1)
  println(result2)

}
