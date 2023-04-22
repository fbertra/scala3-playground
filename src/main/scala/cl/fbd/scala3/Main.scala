package cl.fbd.scala3

@main
def main () = 
    println ("hola pruebas scala 3")

    val list = "abc" :: "123" :: Nil

    for sz <- list do
        println (sz)
    end