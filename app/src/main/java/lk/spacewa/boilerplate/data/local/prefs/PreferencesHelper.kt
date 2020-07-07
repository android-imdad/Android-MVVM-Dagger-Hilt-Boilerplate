package lk.spacewa.boilerplate.data.local.prefs

import lk.spacewa.boilerplate.data.DataManager.LoggedInMode

/**
 * Created by Imdad on 05/11/20.
 */
interface PreferencesHelper {
    var currentAccessToken: String?
    var currentUserEmail: String?
    var currentUserId: Long?
    fun getCurrentUserLoggedInMode(): Int
    fun setCurrentUserLoggedInMode(mode: LoggedInMode)
    var currentUserName: String?
    var currentUserProfilePicUrl: String?
    var selectedLanguage: String?
}