package cl.fbd.scala3

import upickle.default.*

import sttp.client4.quick.*
import sttp.client4.Response

import cl.fbd.scala3.domain.PokemonAblility
import cl.fbd.scala3.domain.PokemonSvc


@main
def main () = 
    println ("test scala-native 0.4.16 + libs toolkit (sttp, upickle)")

    val pa = PokemonAblility (
        id = 1,
        name = "test",
        is_main_series = false
    )

    val sz = write (pa)

    val pokemons = callPokemonAbility (5)
    println (pokemons)


def callPokemonAbility (limit: Int): PokemonSvc =
    val pokemonApiURL = uri"https://pokeapi.co/api/v2/pokemon?limit=${limit}"
    val pokemonAbilityURL = "https://pokeapi.co/api/v2/ability/"

    val response: Response[String] = quickRequest
        .get(pokemonApiURL)
        .send()

    println (response.body)

    read [PokemonSvc] (response.body)    
    
