package cl.fbd.scala3.domain

import upickle.default.*

case class PokemonAblility (
  id: Int,
  name: String,
  is_main_series: Boolean
  // generation
) derives ReadWriter