// ref: https://github.com/scala-native/scala-native.g8/blob/main/src/main/g8/build.sbt

name := "fbd-scala3-pruebas"

version := "0.0.1"

// needed for snapshots
resolvers := Resolver.sonatypeOssRepos("snapshots")

scalaVersion := "3.3.0"

enablePlugins(ScalaNativePlugin)

logLevel := Level.Info

import scala.scalanative.build._

nativeConfig ~= { c =>
  c.withLTO(LTO.none) // thin
    .withMultithreadingSupport(true)
    .withMode(Mode.debug) // releaseFast
    .withGC(GC.immix) // commix
}
