package lk.spacewa.boilerplate.data.remote.repository

import io.reactivex.rxjava3.core.Observable
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import lk.spacewa.boilerplate.data.remote.ApolloRxHelper
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider
import lk.spacewa.trafficops.GetPokemonsQuery
import javax.inject.Inject

/**
 * Created by Imdad on 7/11/2020.
 */
class PokemonRepositoryImpl @Inject constructor(private val mApolloClient: ApolloClient,private val mApolloRxHelper: ApolloRxHelper,private val mRxSchedulers: SchedulerProvider) : PokemonRepository {


    override fun getPokemons(): Observable<Response<GetPokemonsQuery.Data>> {
        val getPokemonsQuery = GetPokemonsQuery.builder().build()
        val getPokemonsCall : ApolloCall<GetPokemonsQuery.Data> = mApolloClient.query(getPokemonsQuery)
        return mApolloRxHelper.from(getPokemonsCall).subscribeOn(mRxSchedulers.io()).observeOn(mRxSchedulers.ui())
    }

}