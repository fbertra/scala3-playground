// ref: https://github.com/scala-native/scala-native.g8/blob/main/src/main/g8/build.sbt

name := "fbd-scala3-pruebas"

version := "0.0.1"

// [info]  published ivy to /home/gitpod/.ivy2/local/ch.epfl.lamp/gears_3/0.1.0-SNAPSHOT/ivys/ivy.xml
libraryDependencies += "ch.epfl.lamp" %% "gears" % "0.1.0-SNAPSHOT"

scalaVersion := "3.3.1"

// libraryDependencies += "com.lihaoyi" % "upickle_native0.4_3" % "3.1.3"

libraryDependencies += "com.lihaoyi" %% "upickle" % "3.1.3"


// libraryDependencies += "com.softwaremill.sttp.client4" % "core_native0.4_3" % "4.0.0-M1" //  "com.softwaremill.sttp.client3" % "core_native0.4_3" % "3.9.0"

libraryDependencies += "com.softwaremill.sttp.client4" %% "core" % "4.0.0-M1" //  "com.softwaremill.sttp.client3" % "core_native0.4_3" % "3.9.0"


// needed for snapshots
// resolvers := Resolver.sonatypeOssRepos("snapshots")

// enablePlugins(ScalaNativePlugin)

// logLevel := Level.Info

// import scala.scalanative.build._

// nativeConfig ~= { c =>
//  c.withLTO(LTO.none) // thin
//    // .withMultithreadingSupport(true)
//    .withMode(Mode.debug) // releaseFast
//    .withGC(GC.immix) // commix
//)
