import sbt._
import bintray.Keys._

organization := "io.kyriakos.library"

name := "kyriakos-lib-crud"

version := "1.0.0"

scalaVersion := "2.11.7"

lazy val kyriakosLibCrud = project.in(file(".")).
  settings(bintrayPublishSettings: _*).
  settings(
    sbtPlugin := false,
    name := "kyriakos-lib-crud",
    licenses += ("MIT", url("https://opensource.org/licenses/MIT")),
    publishMavenStyle := false,
    repository in bintray := "kyriakos",
    bintrayOrganization in bintray := None
  )

resolvers += Resolver.url("edinhodzic", url("http://dl.bintray.com/edinhodzic/kyriakos"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.11.7",
  "io.kyriakos.library" % "kyriakos-lib-domain_2.11" % "1.0.0",
  "io.kyriakos.library" % "kyriakos-lib-utils_2.11" % "1.0.0",
  "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.1.0",
  "io.kamon" % "kamon-core_2.11" % "0.5.2"
)

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

scalacOptions ++= Seq("-deprecation", "-feature")
