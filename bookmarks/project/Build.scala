import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "bookmarks"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.loicdescotte.coffeebean" % "html5tags_2.9.1" % "1.0-RC1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.com/releases/"))(Resolver.ivyStylePatterns)
    )

}
