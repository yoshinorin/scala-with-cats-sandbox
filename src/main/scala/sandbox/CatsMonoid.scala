package sandbox

import cats.Monoid
import cats.syntax.semigroup._

case class Order(totalCost: Double, quantity: Double)

// すごいかさんき
object superAdder {

  /* foldLeft を使った場合
  def add(items: List[Int]): Int = {
    items.foldLeft(0)(_ + _)
  }
  */

  // Monoidを使った場合
  /* 別の型で実装しようとするとコード重複する
  def add(items: List[Int]): Int = {
    items.foldLeft(Monoid[Int].empty)(_ |+| _)
  }
  */

  def add[A](items: List[A])(implicit monoid: Monoid[A]): A = {
   items.foldLeft(monoid.empty)(_ |+| _)
  }

  /* ↑ のコードをcontext bound を使った場合
  def add[A: Monoid](items: List[A]): A = {
    items.foldLeft(Monoid[A].empty)(_ |+| _)
  }
  */

  implicit val monoid: Monoid[Order] = new Monoid[Order] {
    def combine(x: Order, y: Order): Order =
      Order(
        x.totalCost + y.totalCost,
        x.quantity + y.quantity
      )

    def empty: Order = Order(0, 0)
  }

}
