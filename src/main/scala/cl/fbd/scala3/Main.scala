package cl.fbd.scala3

import scala.concurrent.{ Future, ExecutionContext }
import scala.concurrent.duration.Duration
import java.util.concurrent.TimeUnit
import scala.concurrent.Await

@main
def main () = 
    println ("Pruebas con scala 3.3.1, scala-native 0.4.15")
    println ("API concurrencia")

    given ExecutionContext = ExecutionContext.global

    val f = Future:
        slowOp ()

    println (s"main thread")

    val maxWaitTime = Duration(30, TimeUnit.SECONDS)

    val ret = Await.result(f, maxWaitTime)

    println (s"ret = ${ret}")

    
def slowOp (): Int =
    println ("Slow op start")
    Thread.sleep (1000)
    println ("Slow op end")

    1
