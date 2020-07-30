package lk.spacewa.boilerplate.data.remote.repository

import com.apollographql.apollo.api.Response
import io.reactivex.rxjava3.core.Observable
import lk.spacewa.boilerplate.GetPokemonsQuery

/**
 * Created by Imdad on 7/11/2020.
 */
interface PokemonRepository {

    fun getPokemons () : Observable<Response<GetPokemonsQuery.Data>>
}