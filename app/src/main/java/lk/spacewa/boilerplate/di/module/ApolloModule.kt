package lk.spacewa.boilerplate.di.module

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import lk.spacewa.boilerplate.R
import lk.spacewa.boilerplate.data.local.prefs.PreferencesHelper
import okhttp3.OkHttpClient
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Imdad on 7/11/2020.
 */

@Module
@InstallIn(ApplicationComponent::class)
class ApolloModule {

    @Singleton
    @Provides
    fun providePokemonAPI(okHttpClient: OkHttpClient,@ApplicationContext context: Context): ApolloClient {
        return ApolloClient.builder()
                .serverUrl(context.getString(R.string.base_api_url))
                .okHttpClient(okHttpClient)
                .build()
    }
}