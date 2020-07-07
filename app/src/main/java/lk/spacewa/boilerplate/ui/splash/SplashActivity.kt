package lk.spacewa.boilerplate.ui.splash

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import lk.spacewa.boilerplate.BR
import lk.spacewa.boilerplate.R
import lk.spacewa.boilerplate.base.BaseActivity
import lk.spacewa.boilerplate.databinding.ActivitySplashBinding

/**
 * Created by Imdad on 05/11/20.
 */
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding?, SplashViewModel?>(), SplashNavigator {

    private val mSplashViewModel: SplashViewModel by viewModels()
    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_splash

    override val viewModel: SplashViewModel?
        get() {
            return mSplashViewModel
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSplashViewModel.navigator = this


    }

    override fun openLoginActivity() {}
    override fun openMainActivity() {}
    override fun handleError(throwable: Throwable?) {}
}