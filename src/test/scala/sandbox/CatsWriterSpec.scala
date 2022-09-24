package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.data.Writer
import cats.instances.vector._ // for Monoid
import cats.syntax.applicative._ // for pure
import cats.syntax.writer._ // for writer

import sandbox.CatsWriter._

// testOnly sandbox.CatsWriterSpec
class CatsWriterSpec extends AnyWordSpec {

  Writer(Vector(
    "It was the best of times",
    "it was the worst of times"
  ), 1859)

  type Logged[A] = Writer[Vector[String], A]
  123.pure[Logged]

  Vector("msg1", "msg2", "msg3").tell

  val a = Writer(Vector("msg1", "mag2", "mag3"), 123)
  val b = 123.writer(Vector("msg1", "mag2", "mag3"))

  val aResult: Int = a.value
  val aLog: Vector[String] = a.written

  val writer1 = for {
    a <- 10.pure[Logged]
    _ <- Vector("a", "b", "c").tell
    b <- 32.writer(Vector("x", "y", "z"))
  } yield a + b

  val writer2 = writer1.mapWritten(_.map(_.toUpperCase())).run

  val writer3 = writer1.bimap(
    log => log.map(_.toUpperCase),
    res => res * 100
  ).run

  val writer4 = writer1.mapBoth { (log, res) =>
    val log2 = log.map(_ + "!")
    val res2 = res * 1000
    (log2, res2)
  }.run

  println(factorial(5))

}
