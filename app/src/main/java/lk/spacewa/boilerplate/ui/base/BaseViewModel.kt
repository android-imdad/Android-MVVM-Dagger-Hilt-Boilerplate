package lk.spacewa.boilerplate.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import lk.spacewa.boilerplate.data.DataManager
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider
import java.lang.ref.WeakReference

/**
 * Created by Imdad on 05/11/20.
 */
abstract class BaseViewModel<N>(val dataManager: DataManager?,
                                val schedulerProvider: SchedulerProvider?) : ViewModel() {
    var isLoading = ObservableBoolean()
        private set
    val compositeDisposable: CompositeDisposable
    private var mNavigator: WeakReference<N?>? = null
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoadingNew: ObservableBoolean) {
        isLoading = isLoadingNew
    }

    var navigator: N?
        get() = mNavigator!!.get()
        set(value) {
            mNavigator = WeakReference(value)
        }

//    fun setNavigator(navigator: N) {
//        mNavigator = WeakReference(navigator)
//    }

    init {
        compositeDisposable = CompositeDisposable()
    }
}