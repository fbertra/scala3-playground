package cl.fbd.scala3

import scala.concurrent.{ Future, ExecutionContext }
import scala.concurrent.duration.Duration
import java.util.concurrent.TimeUnit
import scala.concurrent.Await

@main
def main () = 
    println ("scala 3.3.0, scala-native 0.5.0-SNAPSHOT, API Future")

    given ExecutionContext = ExecutionContext.global

    val f = Future:
        slowOp ()

    println (s"main thread")

    val maxWaitTime = Duration(30, TimeUnit.SECONDS)

    val ret = Await.result(f, maxWaitTime)

    println (s"ret = ${ret}")

    
def slowOp (): Int =
    println ("Slow op start")
    Thread.sleep (5000)
    println ("Slow op end")

    1
