/**
  * Created by a.shipulin on 08.07.16.
  */
import scala.io._
import scala.util.parsing.json._
import java.net._

object Twitsearch extends App {
  override def main(args: Array[String]) {
    if(args.isEmpty) {
      println("Usage: twitsearch <query>")
      return
    }
    val query = URLEncoder.encode(args(0), "UTF-8")
    //val url = "http://search.twitter.com/search.json?q=" + query
    val url = "https://api.twitter.com/1.1/users/search.json?q=" + query
    val data = Source.fromURL(url).mkString

    JSON.parseFull(data) match {
      case None =>
        println("Failed to parse JSON")
      case Some(j) =>
        val json = j.asInstanceOf[Map[String,List[Map[String,_]]]]
        json("results").map(x => x("text")).foreach(println)
    }
  }
}
