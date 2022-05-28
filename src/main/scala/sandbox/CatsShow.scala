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


  /*
  implicit val catPrintable: Printable[Cat] = {
    new Printable[Cat] {
      def format(cat: Cat): String = {
        s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."
      }
    }
  }
  */

  // ↑ の Printable を Cats の Show を使って再実装する
  implicit val catShow: Show[Cat] = Show.show(cat => s"${cat.name} is a ${cat.age} year-old ${cat.color} cat.")
}
