import sbt._

organization := "io.kyriakos.library"

name := "kyriakos-lib-crud"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val kyriakosLibCrud = project.in(file("."))

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.11.7",
  "io.kyriakos.library" % "kyriakos-lib-domain_2.11" % "0.5.0-SNAPSHOT",
  "io.kyriakos.library" % "kyriakos-lib-utils_2.11" % "0.1.0-SNAPSHOT",
  "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.1.0",
  "io.kamon" % "kamon-core_2.11" % "0.5.2"
)

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

scalacOptions ++= Seq("-deprecation", "-feature")
