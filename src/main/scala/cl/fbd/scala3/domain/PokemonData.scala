package cl.fbd.scala3.domain

import upickle.default.*

case class PokemonData(
  name: String,
  url: String    
) derives ReadWriter
