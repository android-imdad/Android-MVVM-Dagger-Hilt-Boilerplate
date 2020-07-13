package lk.spacewa.boilerplate.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import lk.spacewa.boilerplate.data.DataManager
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider
import java.lang.ref.WeakReference

/**
 * Created by Imdad on 05/11/20.
 */
abstract class BaseViewModel(val dataManager: DataManager?,
                                val schedulerProvider: SchedulerProvider?) : ViewModel() {
    var isLoading = ObservableBoolean()
        private set
    val compositeDisposable: CompositeDisposable


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoadingNew: ObservableBoolean) {
        isLoading = isLoadingNew
    }


    init {
        compositeDisposable = CompositeDisposable()
    }
}