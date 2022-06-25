package sandbox

import org.scalatest.wordspec.AnyWordSpec
import BinaryTreeFunctorInstances._
import cats.syntax.functor._

// testOnly sandbox.BinaryTreeFunctorSpec
class BinaryTreeFunctorSpec extends AnyWordSpec {

  val tree1 = Tree.branch(Tree.leaf(10), Tree.leaf(20))
  println(tree1)
  // Branch(Leaf(10),Leaf(20))

  val tree2 = Tree.leaf(100).map(_ * 2)
  println(tree2)
  // Leaf(200)

  val tree3 = Tree.branch(Tree.leaf(10), Tree.leaf(20)).map(_ * 2)
  println(tree3)
  // Branch(Leaf(20),Leaf(40))
}
