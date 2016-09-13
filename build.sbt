name := "TodoMind"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "com.typesafe" % "config" % "1.3.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-pickling" % "0.10.1"

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.60-R9"

//https://github.com/scalaj/scalaj-http
libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.3.0"

//https://github.com/json4s/json4s
libraryDependencies += "org.json4s" %% "json4s-native" % "3.3.0"

//https://github.com/nscala-time/nscala-time
libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.12.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
