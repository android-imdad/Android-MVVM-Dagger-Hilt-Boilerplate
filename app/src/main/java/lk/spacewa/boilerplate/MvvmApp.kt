package lk.spacewa.boilerplate

import android.app.Application
import com.yariksoffice.lingver.Lingver
import dagger.hilt.android.HiltAndroidApp
import lk.spacewa.boilerplate.utils.AppLogger

/**
 * Created by Imdad on 05/11/20.
 */
@HiltAndroidApp
class MvvmApp : Application() {

//    @Inject
//    var mCalligraphyConfig: CalligraphyConfig? = null


    override fun onCreate() {
        super.onCreate()
        Lingver.init(this, "en")

        AppLogger.init()

//        CalligraphyConfig.initDefault(mCalligraphyConfig)
    }


}