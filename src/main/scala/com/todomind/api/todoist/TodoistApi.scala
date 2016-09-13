package com.todomind.api.todoist


import scalaj.http._
import org.json4s._
/**
  * Created by V-Lamp on 24/04/2016.
  */
class TodoistApi(apiToken: String) {

  def getAllData(apiToken: String) =
   TodoistApi.get("sync", Map("token" -> apiToken,"seq_no" -> "0", "resource_types" -> "[\"all\"]"))
  def allDataProcessed: List[Project] = {
    ???
  }
}
object TodoistApi {
  val apiTokenFromSettings = "1755d57ef6f2951c7016e1e1e5e0d450d4e43bf9"
  type Args = Map[String,String]
  val apiVersion = 6
  val url = s"https://api.todoist.com/API/v$apiVersion/"
  def login(email: String, password: String): HttpResponse[String] =
    get("login", Map("email" -> email, "password" -> password))


  private def get(endPoint:String, params: Args):HttpResponse[String] = {
    Http(url+ "/" +endPoint).params(params).asString
  }
}
