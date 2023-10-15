package cl.fbd.scala3.domain

import upickle.default.*

case class PokemonSrv(
    count: Integer,
    next: String | Null,
    previous: String | Null,
    results: Seq[PokemonData]
) derives ReadWriter
