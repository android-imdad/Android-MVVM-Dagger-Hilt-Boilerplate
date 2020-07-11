package lk.spacewa.boilerplate.data.remote.repository

import android.database.Observable
import lk.spacewa.trafficops.GetPokemonsQuery

/**
 * Created by Imdad on 7/11/2020.
 */
interface PokemonRepository {

    fun getPokemons () : Observable<GetPokemonsQuery>
}