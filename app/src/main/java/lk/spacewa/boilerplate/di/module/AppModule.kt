package lk.spacewa.boilerplate.di.module

//import io.github.inflationx.calligraphy3.CalligraphyConfig
//import lk.spacewa.boilerplate.di.Singleton
import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import lk.spacewa.boilerplate.BuildConfig
import lk.spacewa.boilerplate.data.AppDataManager
import lk.spacewa.boilerplate.data.DataManager
import lk.spacewa.boilerplate.data.local.prefs.PreferencesHelper
import lk.spacewa.boilerplate.data.local.prefs.PreferencesHelperImpl
import lk.spacewa.boilerplate.data.remote.ApiHeader.ProtectedApiHeader
import lk.spacewa.boilerplate.data.remote.ApiHelper
import lk.spacewa.boilerplate.data.remote.AppApiHelper
import lk.spacewa.boilerplate.di.ApiInfo
import lk.spacewa.boilerplate.di.DatabaseInfo
import lk.spacewa.boilerplate.di.PreferenceInfo
import lk.spacewa.boilerplate.utils.AppConstants
import lk.spacewa.boilerplate.utils.rx.AppSchedulerProvider
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider
import javax.inject.Singleton

/**
 * Created by Imdad on 05/11/20.
 */
@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

//    @Provides
//    @Singleton
//    fun provideAppDatabase(@DatabaseInfo dbName: String?, context: Context?): AppDatabase {
//        return Room.databaseBuilder(context!!, AppDatabase::class.java, dbName!!).fallbackToDestructiveMigration()
//                .build()
//    }

//    @Provides
//    @Singleton
//    fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
//        return CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String? {
        return AppConstants.DB_NAME
    }

//    @Provides
//    @Singleton
//    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
//        return appDbHelper
//    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String? {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper {
        return preferencesHelperImpl
    }

    @Provides
    @Singleton
    fun provideProtectedApiHeader(@ApiInfo apiKey: String?,
                                  preferencesHelper: PreferencesHelper): ProtectedApiHeader {
        return ProtectedApiHeader(
                apiKey,
                preferencesHelper.currentUserId,
                preferencesHelper.currentAccessToken)
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}