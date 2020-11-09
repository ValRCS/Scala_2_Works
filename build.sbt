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
//libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.32.3.2"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.28.0"
//// https://mvnrepository.com/artifact/io.getquill/quill-jdbc
libraryDependencies += "io.getquill" %% "quill-jdbc" % "3.6.0-RC3"
//libraryDependencies += "io.getquill" %% "quill-jdbc" % "3.6.0"
//libraryDependencies ++= Seq(
//  "org.xerial" % "sqlite-jdbc" % "3.28.0",
//  "io.getquill" %% "quill-jdbc" % "3.6.0"
//)


//libraryDependencies += "org.clapper" %% "grizzled-slf4j" % "1.3.4"
