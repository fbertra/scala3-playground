package cl.fbd.scala3

// import scala.concurrent.Future
// import scala.concurrent.ExecutionContext
// import scala.concurrent.Await
// import concurrent.duration.DurationInt

import cl.fbd.scala3.domain.PokemonAblility
import cl.fbd.scala3.domain.PokemonSrv
import cl.fbd.scala3.domain.PokemonData

import gears.async.Future
import gears.async.Future.awaitAll
import gears.async.Async
import gears.async.default.given

import cl.fbd.scala3.client.callPokemonSrv
import cl.fbd.scala3.client.callPokemonAbility

@main
def main(limit: Int) =
  println("test scala 3.3.1 JVM + API Gears + lib toolkit (sttp, upickle)")

  val pokemons = getPokemonsAbility(limit)

  for pokemon <- pokemons do println(pokemon)

def getPokemonsAbility(limit: Int): Seq[PokemonAblility] =
  val pokemon_srv = callPokemonSrv(limit)

  // given ExecutionContext = ExecutionContext.global

  Async.blocking:
    val futures = for pokemon <- pokemon_srv.results yield Future(callPokemonAbility(pokemon))

    futures.awaitAll

