import sbt._

organization := "io.otrl.library"

name := "otrl-lib-crud"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val otrlLibCrud = project.in(file("."))

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.11.7",
  "io.otrl.library" % "otrl-lib-domain_2.11" % "0.5.0-SNAPSHOT",
  "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.1.0",
  "io.kamon" % "kamon-core_2.11" % "0.5.2"
)

publishTo := Some("OTRL" at "https://mvn.otrl.io")

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

publishTo := Some("OTRL" at "https://mvn.otrl.io")

scalacOptions ++= Seq("-deprecation", "-feature")
