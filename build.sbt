name := "Testy"

version := "0.1"

scalaVersion := "2.13.3"

//you add libraries here
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.3.0"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"
libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.6"
libraryDependencies += "com.lihaoyi" %% "upickle" % "0.9.5"
libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.7.1"
libraryDependencies += "com.nrinaudo" %% "kantan.xpath" % "0.5.2"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.32.3.2"
//libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.28.0"
//// https://mvnrepository.com/artifact/io.getquill/quill-jdbc
libraryDependencies += "io.getquill" %% "quill-jdbc" % "3.6.0-RC3"
//libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3"
// https://mvnrepository.com/artifact/com.typesafe.slick/slick-codegen
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % "3.3.3"
libraryDependencies += "net.debasishg" %% "redisclient" % "3.30"
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.0.5"
// https://mvnrepository.com/artifact/com.outworkers/phantom-dsl
libraryDependencies += "com.outworkers" %% "phantom-dsl" % "2.59.0"
// https://mvnrepository.com/artifact/org.neo4j.driver/neo4j-java-driver
libraryDependencies += "org.neo4j.driver" % "neo4j-java-driver" % "4.1.1"
// https://mvnrepository.com/artifact/com.dimafeng/neotypes
libraryDependencies += "com.dimafeng" %% "neotypes" % "0.15.1"
//libraryDependencies += "com.dimafeng" %% "neotypes" % "0.15.0"



//libraryDependencies ++= Seq(
//  "com.typesafe.slick" %% "slick" % "3.0.0",
//  "org.slf4j" % "slf4j-nop" % "1.6.4"
//)
//libraryDependencies += "io.getquill" %% "quill-jdbc" % "3.6.0"
//libraryDependencies ++= Seq(
//  "org.xerial" % "sqlite-jdbc" % "3.28.0",
//  "io.getquill" %% "quill-jdbc" % "3.6.0"
//)


//libraryDependencies += "org.clapper" %% "grizzled-slf4j" % "1.3.4"
