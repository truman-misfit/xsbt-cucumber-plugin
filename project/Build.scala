import sbt._
import Keys._

object Settings {
  val buildOrganization = "templemore"
  val buildScalaVersion = "2.9.2"
  val buildVersion      = "0.8.0"

  val buildSettings = Defaults.defaultSettings ++
                      Seq (organization  := buildOrganization,
                           scalaVersion  := buildScalaVersion,
                           version       := buildVersion,
                           scalacOptions += "-deprecation",
                           resolvers += "Templemore Repository" at "http://templemore.co.uk/repo",
                           publishTo := Some(Resolver.file("file",  new File("deploy-repo"))))
}

object Dependencies {
  val cucumber = "info.cukes" %% "cucumber-scala" % "1.1.3-SNAPSHOT" % "compile"
  val testInterface = "org.scala-tools.testing" % "test-interface" % "0.5" % "compile"
}

object Build extends Build {
  import Dependencies._
  import Settings._

  lazy val parentProject = Project("sbt-cucumber-parent", file ("."),
    settings = buildSettings ++
               Seq(crossScalaVersions := Seq("2.9.2", "2.10.0"))) aggregate (pluginProject, integrationProject)

  lazy val pluginProject = Project("sbt-cucumber-plugin", file ("plugin"),
    settings = buildSettings ++ 
               Seq(sbtPlugin := true))

  lazy val integrationProject = Project ("sbt-cucumber-integration", file ("integration"),
    settings = buildSettings ++ 
               Seq(crossScalaVersions := Seq("2.9.2", "2.10.0"),
                   libraryDependencies ++= Seq(cucumber, testInterface)))
}

