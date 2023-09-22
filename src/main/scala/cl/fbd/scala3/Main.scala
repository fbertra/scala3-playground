package cl.fbd.scala3

import util.boundary, boundary.break

@main
def main () = 
    println ("Pruebas con scala 3.3.1 y scala-native 0.4.15")

    val list = "abc" :: "123" :: "xyz" :: "a8b1" :: Nil

    val primeraCadenaConDigito = boundary:
        for sz <- list do
            println (sz)

            if sz.exists (Character.isDigit) then break (sz)

        "ninguna cadena contiene digitos"

    println (s"La primera cadena que contiene digitos es $primeraCadenaConDigito")