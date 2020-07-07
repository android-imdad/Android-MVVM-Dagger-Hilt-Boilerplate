package lk.spacewa.boilerplate.ui.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.scopes.ActivityScoped
import lk.spacewa.boilerplate.base.BaseViewModel
import lk.spacewa.boilerplate.data.DataManager
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider

/**
 * Created by Imdad on 05/11/20.
 */
@ActivityScoped
class SplashViewModel @ViewModelInject constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SplashNavigator?>(dataManager, schedulerProvider){




}