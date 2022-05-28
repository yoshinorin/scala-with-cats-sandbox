package sandbox

import java.util.Date
import cats.Show

object catsShow {
  /*
  implicit val dateShow: Show[Date] =
    new Show[Date] {
      def show(date: Date): String =
        s"${date.getTime}ms since the epoch."
    }
  */

  // 定義されたメソッドを使うと ↑ のようなコードを書く必要はない
  implicit val dateShow: Show[Date] = Show.show(date => s"${date.getTime}ms since the epoch.")
}
