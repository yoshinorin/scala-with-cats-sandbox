package sandbox

import cats.Eval

object CatsEval {

  /* この実装では非スタックセーフ
  def unStackSafefactorial(n: BigInt): Eval[BigInt] = {
    if(n == 1) {
      Eval.now(n)
    } else {
      factorial(n - 1).map(_ * n)
    }
  }
  */

  def stackSafeFactorial(n: BigInt): Eval[BigInt] = {
    if(n == 1) {
      Eval.now(n)
    } else {
      Eval.defer(stackSafeFactorial(n - 1).map(_ * n))
    }
  }

  /*
  def unStackSafeFoldRight[A, B](as: List[A], acc: B)(fn: (A, B) => B): B = {
    as match {
      case head :: tail =>
        fn(head, unStackSafeFoldRight(tail, acc)(fn))
      case Nil =>
        acc
    }
  }
  */

  def stackSafeFoldRight[A, B](as: List[A], acc: Eval[B])(fn: (A, Eval[B]) => Eval[B]): Eval[B] = {
    as match {
      case head :: tail =>
        Eval.defer(fn(head, stackSafeFoldRight(tail, acc)(fn)))
      case Nil =>
        acc
    }
  }

  def foldRight[A, B](as: List[A], acc: B)(fn: (A, B) => B): B = {
    stackSafeFoldRight(as, Eval.now(acc)) { (a, b) =>
      b.map(fn(a, _))
    }.value
  }

}
