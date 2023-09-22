// ref: https://github.com/scala-native/scala-native.g8/blob/main/src/main/g8/build.sbt

name := "fbd-scala3-pruebas"

version := "0.0.1"

scalaVersion := "3.3.1"

enablePlugins(ScalaNativePlugin)

logLevel := Level.Info

import scala.scalanative.build._

nativeConfig ~= { c =>
  c.withLTO(LTO.none) // thin
    .withMode(Mode.debug) // releaseFast
    .withGC(GC.immix) // commix
}