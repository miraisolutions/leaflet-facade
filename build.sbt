import de.heikoseeberger.sbtheader.HeaderPattern
headers := Map(
  "scala" -> (
    HeaderPattern.cStyleBlockComment,
    s"""/* Copyright (c) 2016 CiBO Technologies - All Rights Reserved
        | * You may use, distribute, and modify this code under the
        | * terms of the BSD 3-Clause license.
        | *
        | * A copy of the license can be found on the root of this repository,
        | * at ${homepage.value.get.toString}/LICENSE.md,
        | * or at https://opensource.org/licenses/BSD-3-Clause
        | */
        |
       |""".stripMargin
    )
)

name := "leaflet-facade"
organization := "com.cibo"

homepage := Some(url("https://github.com/cibotech/leaflet-facade"))
licenses += ("BSD Simplified", url("https://opensource.org/licenses/BSD-3-Clause"))
scmInfo := Some(ScmInfo(
  url("https://github.com/cibotech/leaflet-facade"),
  "scm:git:git@github.com/cibotech/leaflet-facade.git",
  Some("scm:git:git@github.com/cibotech/leaflet-facade.git")))

publishMavenStyle := true
publishArtifact in Test := false
publishArtifact in IntegrationTest := false

scalaVersion := "2.12.4"
crossScalaVersions := Seq("2.11.8", "2.12.4")
releaseCrossBuild := true

lazy val root = project.in(file("."))
    .settings(
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.9.4"
      ),
      jsDependencies ++= Seq(
        "org.webjars.bower" % "leaflet" % "1.0.3"
          / "leaflet.js"
      )
    )
  .enablePlugins(ScalaJSPlugin)
