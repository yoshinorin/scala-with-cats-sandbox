package sandbox

import cats.data.Reader
import cats.syntax.applicative._

final case class Db(
  usernames: Map[Int, String],
  passwords: Map[String, String]
)

object CatsReader {

  type DbReader[A] = Reader[Db, A]

  def findUsername(userId: Int): DbReader[Option[String]] = {
    Reader(db => db.usernames.get(userId))
  }

  def checkPassword(
    username: String,
    password: String): DbReader[Boolean] = {
      Reader(db => db.passwords.get(username).contains(password))
    }

  def checkLogin(
        userId: Int,
        password: String): DbReader[Boolean] = {

          for {
            username <- findUsername(userId)
            result <- username.map { username =>
              checkPassword(username, password)
            }.getOrElse {
              false.pure[DbReader]
            }
          } yield result
  }

}
