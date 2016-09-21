name := "TodoMind"

organization := "com.github.v-lamp"

version := "0.1"

scalaVersion := "2.11.8"


libraryDependencies ++=
  todoistApiDependencies ++
    testingLibraries ++ 
    utilityLibraries ++
    commandLineAppLibraries

lazy val todoistApiDependencies = {
  //https://github.com/nscala-time/nscala-time
  val timeLibForScala = "com.github.nscala-time" %% "nscala-time" % "2.14.0"
  //https://github.com/scalaj/scalaj-http
  val httpLib = "org.scalaj" %% "scalaj-http" % "2.3.0"
  
  jsonLibraries ++ Seq(timeLibForScala, httpLib)
}
lazy val jsonLibraries = {
  //https://github.com/travisbrown/circe
  val circe = {
    val circeVersion = "0.5.2"
    Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % circeVersion)
  }
  //https://github.com/json4s/json4s
  val json4s = "org.json4s" %% "json4s-native" % "3.4.0"
  json4s +: circe
}

lazy val guiAppLibraries = {
  //https://github.com/scalafx/scalafx
  val scalafx = "org.scalafx" %% "scalafx" % "8.0.102-R11"
  Seq(scalafx)
}
lazy val commandLineAppLibraries = {
  //https://github.com/scopt/scopt
  val argumentParsing = "com.github.scopt" %% "scopt" % "3.5.0"
  val jline = "jline" % "jline" % "2.14.2"
  Seq(argumentParsing, jline)
}

lazy val testingLibraries = Seq(
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test")

lazy val utilityLibraries = {
  val config = "com.typesafe" % "config" % "1.3.0"
  val poorMansDb = "org.scala-lang.modules" %% "scala-pickling" % "0.10.1"
  Seq(config, poorMansDb)
}

