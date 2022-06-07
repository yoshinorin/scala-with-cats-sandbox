package sandbox

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Semigroup {
  def apply[A](implicit semigroup: Semigroup[A]) = semigroup
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]) = monoid
}

object BooleanMonoidInstances {
  implicit val booleanAndMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      def combine(x: Boolean, y: Boolean): Boolean = x && y
      def empty: Boolean = true
    }

  implicit val booleanOrMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      def combine(x: Boolean, y: Boolean): Boolean = x || y
      def empty: Boolean = false
    }

  implicit val booleanEitherMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      def combine(x: Boolean, y: Boolean): Boolean = (x && !y) || (!x && y)
      def empty: Boolean = false
    }

  implicit val booleanXnorMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      def combine(x: Boolean, y: Boolean): Boolean = (x || !y) && (!x || y)
      def empty: Boolean = true
    }
}

object SetMonoidInstances {

  implicit def setUnionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    def combine(x: Set[A], y: Set[A]): Set[A] = x union y
    def empty: Set[A] = Set.empty[A]
  }

  implicit def setIntersectionSemigroup[A]: Semigroup[Set[A]] =
    new Semigroup[Set[A]] {
      def combine(x: Set[A], y: Set[A]): Set[A] = x intersect y
    }

  implicit def symmetricDiffMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      def combine(x: Set[A], y: Set[A]): Set[A] = (x diff y) union (y diff x)
      def empty: Set[A] = Set.empty
    }
}
