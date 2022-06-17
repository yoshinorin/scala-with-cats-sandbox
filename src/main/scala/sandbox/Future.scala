package sandbox

import scala.util.Random
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureSandbox {

  val future1 = {
    // 固定したシードでRandomを初期化
    val r = new Random(0L)

    // nextInt は副作用シーケンスの次の乱数に移動するという副作用持ちます
    val x = Future(r.nextInt())

    for {
      a <- x
      b <- x
    } yield (a, b)
  }

    val future2 = {
    val r = new Random(0L)

    for {
      a <- Future(r.nextInt())
      b <- Future(r.nextInt())
    } yield (a, b)
  }
}
