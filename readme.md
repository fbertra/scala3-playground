## Notes on branches

- main: JVM, multi-threading with API Future, API toolkit (sttp, upickle)
- sn_0_4: scala-native 0.4.x, API toolkit
- sn_native_0_5_snapshot: scala-native 0.5, multi-threading with API Future

## Notes on testing multi-threading on JVM

TO-DO: error management

## Notes on testing multi-threading on scala-native 0.5.0 snapshot

- configure sonatype snapshots in build.sbt AND project/plugin.sbt,
- enable multi-threading mode in build.sbt,

TO-DO: test multi-threading and toolkit API's (upickle, sttp, os-lib):
- invoke a REST API (pokemon?)
- read a file

## Notes on gitpod VM configuration

Java: version 11.0.20

See config.sh to install:
- coursier, scala, SBT
- clang

TO-DO: use gitpod project to pre-configure VM.
