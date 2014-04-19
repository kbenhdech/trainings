import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "mySlickApp"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    "org.scalatest" % "scalatest_2.10.0-M7" % "2.0.M4-2.10.0-M7-B1" % "test",
    "com.typesafe" % "slick_2.10.0-M7" % "0.11.1",
    "org.scala-lang" % "scala-actors" % "2.10.0-M7" % "test"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    testOptions in Test := Nil
    // Add your own project settings here      
  )

}
