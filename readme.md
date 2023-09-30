# comandos en la terminal de gitpod

Java
version 11.0.20 instalada

ver config.sh para instalar:
- coursier: https://www.scala-lang.org/download/
- scala, SBT
- clang

# API Future with Scala-jvm, scala-native 0.4.15 and 0.5.0 snapshot

Output with Scala 3.3.0 JVM

prints:
    main thread
    Slow op start
    Slow op end
    ret = 1

then return

Output with Scala 3.3.0 + SN 0.4.15

prints:
    main thread

then hangs for much than 30 segs:

then prints
    java.util.concurrent.TimeoutException: Future timed out after [30 seconds]
            at java.lang.StackTrace$.currentStackTrace$$anonfun$1(Unknown Source)
            at java.lang.StackTrace$$$Lambda$2.applyVoid(Unknown Source)
            ....

finally return

Output with Scala 3.3.0 + SN 0.5.0-SNAPSHOT

prints
    main thread

then hangs for much longer than 30 seconds

then prints
Exception in thread "main"java.util.concurrent.TimeoutException: Future timed out after [30 seconds]
        at scala.concurrent.impl.Promise$DefaultPromise.tryAwait0(Unknown Source)
        at scala.concurrent.impl.Promise$DefaultPromise.result(Unknown Source)

finally returns


