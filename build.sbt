import com.typesafe.sbt.web.Import.WebKeys

scalaVersion in ThisBuild := "2.12.4"
scalafmtOnCompile in ThisBuild := true

lazy val root = (project in file("."))
  .settings(
    organization := "ba.sake",
    version := "0.0.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "ba.sake" %% "hepek" % "0.1.1"
    ),
    (hepek in Compile) := {
      WebKeys.assets.value // run 'assets' after compiling...
      (hepek in Compile).value
    },
    WebKeys.webModulesLib := "site/lib"
  )
  .enablePlugins(HepekPlugin, SbtWeb)
