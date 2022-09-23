package sandbox

import org.scalatest.wordspec.AnyWordSpec
import cats.data.Writer
import cats.instances.vector._ // for Monoid
import cats.syntax.applicative._ // for pure
import cats.syntax.writer._ // for writer

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
}
