package cl.fbd.scala3

import upickle.default.*

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import scala.concurrent.Await
import concurrent.duration.DurationInt

import sttp.client4.quick.*
import sttp.client4.Response
import sttp.model.Uri

import cl.fbd.scala3.domain.PokemonAblility
import cl.fbd.scala3.domain.PokemonSrv
import cl.fbd.scala3.domain.PokemonData

import gears.async.default.given

@main
def main(limit: Int) =
  println("test scala 3.3.1 JVM + API Future + lib toolkit (sttp, upickle)")

  val pokemons = getPokemonsAbility(limit)

  for pokemon <- pokemons do println(pokemon)

def getPokemonsAbility(limit: Int): Seq[PokemonAblility] =
  val pokemon_srv = callPokemonSrv(limit)

  given ExecutionContext = ExecutionContext.global

  val futures =
    for pokemon <- pokemon_srv.results yield Future(callPokemonAbility(pokemon))

  val all = Future.sequence(futures)

  Await.result(all, 10.seconds)

def callPokemonSrv(limit: Int) =
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
