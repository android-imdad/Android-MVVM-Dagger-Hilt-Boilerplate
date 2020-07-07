package lk.spacewa.boilerplate.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import lk.spacewa.boilerplate.data.DataManager.LoggedInMode
import lk.spacewa.boilerplate.data.local.prefs.PreferencesHelper
import lk.spacewa.boilerplate.data.remote.ApiHeader
import lk.spacewa.boilerplate.data.remote.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Imdad on 05/11/20.
 */
@Singleton
class AppDataManager @Inject constructor(private val mContext: Context, private val mPreferencesHelper: PreferencesHelper, private val mApiHelper: ApiHelper, private val mGson: Gson) : DataManager {


    override var currentAccessToken: String?
        get() = mPreferencesHelper.currentAccessToken
        set(accessToken) {
            mPreferencesHelper.currentAccessToken = accessToken
            mApiHelper.apiHeader?.protectedApiHeader?.accessToken = accessToken
        }


    override val apiHeader: ApiHeader?
        get() = mApiHelper.apiHeader

    override var currentUserEmail: String?
        get() = mPreferencesHelper.currentUserEmail
        set(email) {
            mPreferencesHelper.currentUserEmail = email
        }

    override var currentUserId: Long?
        get() = mPreferencesHelper.currentUserId
        set(userId) {
            mPreferencesHelper.currentUserId = userId
        }

    override fun getCurrentUserLoggedInMode(): Int {
        return mPreferencesHelper.getCurrentUserLoggedInMode()
    }

    override fun setCurrentUserLoggedInMode(mode: LoggedInMode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode)
    }

    override var currentUserName: String?
        get() = mPreferencesHelper.currentUserName
        set(userName) {
            mPreferencesHelper.currentUserName = userName
        }

    override var currentUserProfilePicUrl: String?
        get() = mPreferencesHelper.currentUserProfilePicUrl
        set(profilePicUrl) {
            mPreferencesHelper.currentUserProfilePicUrl = profilePicUrl
        }

    override var selectedLanguage: String?
        get() = mPreferencesHelper.selectedLanguage
        set(selectedLanguage) {
            mPreferencesHelper.selectedLanguage = selectedLanguage
        }


    override fun setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null)
    }

    override fun updateApiHeader(userId: Long?, accessToken: String?) {
        mApiHelper.apiHeader?.protectedApiHeader?.userId = userId
        mApiHelper.apiHeader?.protectedApiHeader?.accessToken = accessToken
    }

    override fun updateUserInfo(
            accessToken: String?,
            userId: Long?,
            loggedInMode: LoggedInMode,
            userName: String?,
            email: String?,
            profilePicPath: String?) {
        currentAccessToken = accessToken
        currentUserId = userId
        setCurrentUserLoggedInMode(loggedInMode)
        currentUserName = userName
        currentUserEmail = email
        currentUserProfilePicUrl = profilePicPath
        updateApiHeader(userId, accessToken)
    }


    companion object {
        private const val TAG = "AppDataManager"
    }

}