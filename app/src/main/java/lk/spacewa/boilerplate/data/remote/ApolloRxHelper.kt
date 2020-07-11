package lk.spacewa.boilerplate.data.remote

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloQueryWatcher
import com.apollographql.apollo.ApolloSubscriptionCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx3.Rx3Apollo
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import javax.annotation.Nonnull

/**
 * Wrapper to Rx2Apollo static methods to improve testability
 */
class ApolloRxHelper {
    fun <T> from(watcher: ApolloSubscriptionCall<T>): Flowable<Response<T>> {
        return Rx3Apollo.from(watcher)
    }

    fun <T> from(watcher: ApolloQueryWatcher<T>): Observable<Response<T>> {
        return Rx3Apollo.from(watcher)
    }

    fun <T> from(call: ApolloCall<T>): Observable<Response<T>> {
        return Rx3Apollo.from(call)
    }
}