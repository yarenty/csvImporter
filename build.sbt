version := "1.0.0"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.10.1"

libraryDependencies += "com.netflix.rxjava" % "rxjava-scala" % "0.15.0"

libraryDependencies += "org.json4s" % "json4s-native_2.10" % "3.2.5"

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10.3"

libraryDependencies += "net.databinder.dispatch" % "dispatch-core_2.10" % "0.11.0"

libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.3"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.5"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.5"

libraryDependencies += "com.squareup.retrofit" % "retrofit" % "1.0.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-async" % "0.9.0-M2"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.3"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.2.3"

// specific to CSV Importer

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.1.2"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"

//libraryDependencies += "org.scalaquery" % "scalaquery_2.8.1" % "0.9.5"
//libraryDependencies += "org.scalaquery" % "scalaquery_2.9.1" % "0.10.0-M1"
//libraryDependencies += "org.scalaquery" %% "scalaquery" % "0.9.5"

resolvers += "Local Maven Repository" at ""+Path.userHome.asFile.toURI.toURL+".m2/repository"


