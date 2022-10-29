package sandbox

import cats.data.EitherT
import scala.concurrent.Future
import cats.instances.future._ // for Monad
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._

object TransformerRollOut {

  type Response[A] = EitherT[Future, String, A]

  val powerLevels = Map(
    "Jazz"      -> 6,
    "Bumblebee" -> 8,
    "Hot Rod"   -> 10
  )

  def getPowerLevel(ally: String): Response[Int] = {
    powerLevels.get(ally) match {
      case Some(avg) => EitherT.right(Future(avg))
      case None      => EitherT.left(Future(s"$ally unreachable"))
    }
  }

  /* これでもOKなはず
  def getPowerLevel(autobot: String): Response[Int] = {
    powerLevels.find(_._1 == autobot) match {
      case None => EitherT.leftT(autobot)
      case Some(v) => EitherT.rightT(v._2)
    }
  }
  */

  def canSpecialMove(ally1: String, ally2: String): Response[Boolean] = {
    for {
      a1 <- getPowerLevel(ally1)
      a2 <- getPowerLevel(ally2)
    } yield (a1 + a2) > 15
  }

  def tacticalReport(ally1: String, ally2: String): String = {
    val stack = canSpecialMove(ally1, ally2).value
    Await.result(stack, Duration.Inf) match {
      case Left(value) => s"Error :$value"
      case Right(value) => if (value) s"$ally1 and $ally2 are ready to roll out!" else s"$ally1 and $ally2 need a recharge."
    }
  }

}
