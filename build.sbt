lazy val `sbt-multi-jvm` = project in file(".")

sbtPlugin := true

organization := "com.typesafe.sbt"
name := "sbt-multi-jvm"

// fixed in https://github.com/sbt/sbt/pull/3397 (for sbt 0.13.17)
sbtBinaryVersion in update := (sbtBinaryVersion in pluginCrossBuild).value

// dependencies
libraryDependencies += Defaults.sbtPluginExtra(
  "com.eed3si9n" % "sbt-assembly" % "0.14.10",
  (sbtBinaryVersion in pluginCrossBuild).value,
  (scalaBinaryVersion in pluginCrossBuild).value
)

// compile settings
scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-encoding", "UTF-8"
)

// publish settings
publishMavenStyle := false
licenses += "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")
