package lk.spacewa.boilerplate.data.remote.repository

import com.apollographql.apollo.ApolloClient
import io.reactivex.rxjava3.schedulers.Schedulers
import lk.spacewa.boilerplate.data.remote.ApolloRxHelper
import javax.inject.Inject

/**
 * Created by Imdad on 7/11/2020.
 */
class PokemonRepositoryImpl @Inject constructor(private val mApolloClient: ApolloClient,private val mApolloRxHelper: ApolloRxHelper,private val mRxSchedulers: Schedulers) {

}