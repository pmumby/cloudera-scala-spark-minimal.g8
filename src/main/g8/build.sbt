name := "$name$"
version := "$version$"
scalaVersion := "$scala_version$"
organization := "$package$"
organizationName := "$organization_name$"

fork in Test := true
parallelExecution in Test := false
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8",
  "org.apache.spark" %% "spark-core" % "$spark_version$" % "provided",
  $if(use_kudu.truthy)$
  "org.apache.kudu" %% "kudu-spark2" % "1.7.0",
  $endif$
  "org.apache.spark" %% "spark-sql" % "$spark_version$" % "provided",
  "com.holdenkarau" %% "spark-testing-base" % "$spark_version$_0.12.0" % "test"
)

assemblyMergeStrategy in assembly := {
  case PathList("org", "apache", "spark", "unused", xs@_*) => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

assemblyJarName := "$name$-$version$.jar"
