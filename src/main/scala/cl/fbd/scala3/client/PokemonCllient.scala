package cl.fbd.scala3.client

import upickle.default.*

import sttp.client4.quick.*
import sttp.client4.Response
import sttp.model.Uri

import cl.fbd.scala3.domain.PokemonSrv
import cl.fbd.scala3.domain.PokemonData
import cl.fbd.scala3.domain.PokemonAblility

def callPokemonSrv(limit: Int): PokemonSrv =
  val response_body = call(
    uri"https://pokeapi.co/api/v2/pokemon?limit=${limit}"
  )

  read[PokemonSrv](response_body)

def callPokemonAbility(pokemonData: PokemonData) =
  val urlSplitted = pokemonData.url.split("/")

  val id = urlSplitted(urlSplitted.length - 1)

  val response_body = call(uri"https://pokeapi.co/api/v2/ability/${id}")

  read[PokemonAblility](response_body)

def call(uri: Uri): String =
  val response: Response[String] = quickRequest
    .get(uri)
    .send()

  println(s"${uri} ->\n ${response.body}")

  response.body

