package lk.spacewa.boilerplate.data.remote

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Imdad on 05/11/20.
 */
@Singleton
class AppApiHelper @Inject constructor(private val mApiHeader: ApiHeader) : ApiHelper {
    override val apiHeader: ApiHeader?
        get() = mApiHeader

}