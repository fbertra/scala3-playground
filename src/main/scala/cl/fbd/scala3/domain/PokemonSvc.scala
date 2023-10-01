package cl.fbd.scala3.domain

import upickle.default.*

case class PokemonSvc(
  count: Integer,
  next: Option [String],
  previous: Option [String],
  results: Seq [PokemonData]    
) derives ReadWriter
