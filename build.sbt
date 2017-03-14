name := "PreInterviewTest"

scalaVersion := "2.11.8"

scalacOptions += "-feature"

fork in (Test, run) := true

javaOptions in (Test, run) += "-Xmx8G"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"

