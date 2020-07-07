package lk.spacewa.boilerplate

//import dagger.android.HasActivityInjector
//import io.github.inflationx.calligraphy3.CalligraphyConfig
import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.yariksoffice.lingver.Lingver
import dagger.hilt.android.HiltAndroidApp
import lk.spacewa.boilerplate.utils.AppLogger

/**
 * Created by Imdad on 05/11/20.
 */
@HiltAndroidApp
class MvvmApp : Application() {

//    @Inject
//    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null
//    @kotlin.jvm.JvmField

//    @Inject
//    var mCalligraphyConfig: CalligraphyConfig? = null


    override fun onCreate() {
        super.onCreate()
        Lingver.init(this, "en")

        AppLogger.init()
        AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }
//        CalligraphyConfig.initDefault(mCalligraphyConfig)
    }


}