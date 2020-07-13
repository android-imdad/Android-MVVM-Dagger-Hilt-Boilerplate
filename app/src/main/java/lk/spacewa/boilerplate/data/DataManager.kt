package lk.spacewa.boilerplate.data

import lk.spacewa.boilerplate.data.local.prefs.PreferencesHelper
import lk.spacewa.boilerplate.data.remote.repository.PokemonRepository

/**
 * Created by Imdad on 05/11/20.
 */
interface DataManager : PreferencesHelper,PokemonRepository {
    fun setUserAsLoggedOut()
    fun updateUserInfo(
            accessToken: String?,
            userId: Long?,
            loggedInMode: LoggedInMode,
            userName: String?,
            email: String?,
            profilePicPath: String?)


    enum class LoggedInMode(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0), LOGGED_IN_MODE_GOOGLE(1), LOGGED_IN_MODE_FB(2), LOGGED_IN_MODE_SERVER(3);

    }
}