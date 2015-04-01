import sbt._
import Keys._
import Tests._

/**
 * This is a simple sbt setup generating Slick code from the given
 * database before compiling the projects code.
 */
object myBuild extends Build {
  lazy val mainProject = Project(
    id="main",
    base=file("."),
    settings = Project.defaultSettings ++ Seq(
      scalaVersion := "2.10.3",
      libraryDependencies ++= List(
        "com.typesafe.slick" %% "slick" % "2.1.0",
        "com.typesafe.slick" %% "slick-codegen" % "2.1.0-RC3",
        "org.slf4j" % "slf4j-nop" % "1.6.4",
        "mysql" % "mysql-connector-java" % "5.1.34"
      ),
      slick <<= slickCodeGenTask, // register manual sbt command
      sourceGenerators in Compile <+= slickCodeGenTask // register automatic code generation on every compile, remove for only manual use
    )
  ) 

  // code generation task
  lazy val slick = TaskKey[Seq[File]]("gen-tables")
  lazy val slickCodeGenTask = (sourceManaged, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
    val outputDir = (dir / "slick").getPath // place generated files in sbt's managed sources folder
    val url = "jdbc:mysql://localhost:3306/eshop" // connection info for a pre-populated throw-away, in-memory db for this demo, which is freshly initialized on every run
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val slickDriver = "scala.slick.driver.MySQLDriver"
    val pkg = "com.yarenty.pix.table"
    val user="root"
    val pass =""
    toError(r.run("scala.slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg, user, pass), s.log))
    val fname = outputDir + "/com/yarenty/pix/table/Tables.scala"
    Seq(file(fname))
  }
}