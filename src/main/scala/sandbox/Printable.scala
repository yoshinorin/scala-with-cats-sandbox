package sandbox

final case class Box[A](value: A)

trait Printable[A] { self =>
  def format(value: A): String

  def contramap[B](func: B => A): Printable[B] =
    new Printable[B] {
      def format(value: B): String = self.format(func(value))
    }
}

object PrintableInstances {

  /*
    contramap を使用せずに完全に定義した場合

  implicit def boxPrintable[A](
      implicit p: Printable[A]
  ): Printable[Box[A]] =
    new Printable[Box[A]] {
      def format(box: Box[A]): String = p.format(box.value)
    }
  */

  // contramap を使用した場合
  implicit def boxPrintable[A](implicit p: Printable[A]): Printable[Box[A]] = {
    p.contramap[Box[A]](_.value)
  }

  implicit val stringPrintable: Printable[String] = {
    new Printable[String] {
      def format(value: String): String = value
    }
  }

  implicit val booleanPrintable: Printable[Boolean] =
    new Printable[Boolean] {
      def format(value: Boolean): String =
        if(value) "yes" else "no"
    }

  implicit val intPrintable: Printable[Int] = {
    new Printable[Int] {
      def format(value: Int): String = value.toString()
    }
  }

  implicit val catPrintable: Printable[Cat] = {
    new Printable[Cat] {
      def format(cat: Cat): String = {
        s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."
      }
    }
  }

}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = {
    p.format(value)
  }

  def print[A](value: A)(implicit p: Printable[A]): Unit = {
    println(format(value))
  }
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String = p.format(value)
    def print(implicit p: Printable[A]): Unit = println(p.format(value))
  }
}
