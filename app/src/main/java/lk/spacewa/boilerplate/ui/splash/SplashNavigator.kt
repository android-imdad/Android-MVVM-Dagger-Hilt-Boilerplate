package lk.spacewa.boilerplate.ui.splash

/**
 * Created by Imdad on 05/11/20.
 */
interface SplashNavigator {
    fun openLoginActivity()
    fun openMainActivity()
    fun handleError(throwable: Throwable?)
}