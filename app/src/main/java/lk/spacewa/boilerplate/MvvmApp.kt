package lk.spacewa.boilerplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import lk.spacewa.boilerplate.utils.AppLogger

/**
 * Created by Imdad on 05/11/20.
 */
@HiltAndroidApp
class MvvmApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppLogger.init()

    }


}