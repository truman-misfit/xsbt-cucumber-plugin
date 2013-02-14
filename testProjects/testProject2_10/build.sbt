name := "test-project2_10"

version := "0.8.0"

organization := "templemore"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
	"org.scalatest" % "scalatest_2.10.0" % "1.8" % "test"
)

seq(cucumberSettingsWithTestPhaseIntegration : _*)

cucumberStepsBasePackage := "test"

cucumberHtmlReport := true

cucumberJunitReport := true 

cucumberJsonReport := true
