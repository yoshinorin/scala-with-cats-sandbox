package sandbox

import java.util.Date
import cats.Eq
import cats.instances.long._
import cats.syntax.eq._

object EqExample {
  implicit val dateEq: Eq[Date] =
    Eq.instance[Date] { (date1, date2) =>
      date1.getTime === date2.getTime
      //eqLong.eqv(date1.getTime, date2.getTime)
    }

  //implicit val eqCat = Eq[Cat]

  implicit val catEq: Eq[Cat] =
    Eq.instance[Cat] { (cat1, cat2) =>
      cat1 === cat2
    }

}
