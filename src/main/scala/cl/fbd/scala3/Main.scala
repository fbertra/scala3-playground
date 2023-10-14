package cl.fbd.scala3

import upickle.default.*

import sttp.client4.quick.*
import sttp.client4.Response

import cl.fbd.scala3.domain.PokemonAblility
import cl.fbd.scala3.domain.PokemonSvc
import cl.fbd.scala3.domain.PokemonData


@main
def main () = 
    println ("test scala 3.3.1 JVM + libs toolkit (sttp, upickle)")

    val pa = PokemonAblility (
        id = 1,
        name = "test",
        is_main_series = false
    )

    val sz = write (pa)

    // testParse ()

    val pokemons = callPokemonAbility (5)
    println (pokemons)

def testParse () =
    val test = """{"name":"bulbasaur","url":"https://pokeapi.co/api/v2/pokemon/1/"}"""

    println ("one")
    val res = read [PokemonData] (test)    
    println (res)

    println ("seq")
    val test_seq = """[{"name":"bulbasaur","url":"https://pokeapi.co/api/v2/pokemon/1/"},{"name":"ivysaur","url":"https://pokeapi.co/api/v2/pokemon/2/"}]"""
    val res_seq = read [Seq [PokemonData]] (test_seq)    
    println (res_seq.mkString ("\n"))

    println ("srv")
                    //01234567890123456789
    val test_srv = """{"count":1292,"next":"https://pokeapi.co/api/v2/pokemon?offset=5&limit=5","previous":null,"results":[{"name":"bulbasaur","url":"https://pokeapi.co/api/v2/pokemon/1/"},{"name":"ivysaur","url":"https://pokeapi.co/api/v2/pokemon/2/"},{"name":"venusaur","url":"https://pokeapi.co/api/v2/pokemon/3/"},{"name":"charmander","url":"https://pokeapi.co/api/v2/pokemon/4/"},{"name":"charmeleon","url":"https://pokeapi.co/api/v2/pokemon/5/"}]}"""
    read [PokemonSvc] (test_srv) 
    println (test_srv)


def callPokemonAbility (limit: Int): PokemonSvc =
    val pokemonApiURL = uri"https://pokeapi.co/api/v2/pokemon?limit=${limit}"
    val pokemonAbilityURL = "https://pokeapi.co/api/v2/ability/"

    val response: Response[String] = quickRequest
        .get(pokemonApiURL)
        .send()

    println (response.body)

    read [PokemonSvc] (response.body)    
    
