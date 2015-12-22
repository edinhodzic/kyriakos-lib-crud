import sbt._

organization := "io.otrl.library"

name := "otrl-lib-repository"

version := "0.5.0-SNAPSHOT"
scalaVersion := "2.11.7"

lazy val otrlLibraryRepository = project.in(file("."))

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.11.7",
  "io.otrl.library" % "otrl-lib-domain_2.11" % "0.5.0-SNAPSHOT"
)

scalacOptions += "-feature"
