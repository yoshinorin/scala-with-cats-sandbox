package sandbox

import org.scalatest.wordspec.AnyWordSpec
import JsonWriterInstances._
import JsonSyntax._


// testOnly sandbox.JsonSpec
class JsonSpec extends AnyWordSpec {

  val p = Json.toJson(Person("Hoge", "hoge@example.com"))
  // Json.toJson(Person("Hoge", "hoge@example.com"))(personWriter)

  // JsObject(Map(name -> JsString(Hoge), email -> JsString(hoge@example.com)))
  println(p)

  val p2 = Person("ImportSyntax", "import-syntax@example.com").toJson
  // Person("ImportSyntax", "import-syntax@example.com").toJson(personWriter)

  // JsObject(Map(name -> JsString(ImportSyntax), email -> JsString(import-syntax@example.com)))
  println(p2)

  println(implicitly[JsonWriter[String]])
  // sandbox.JsonWriterInstances$$anon$1@3d408778

}
