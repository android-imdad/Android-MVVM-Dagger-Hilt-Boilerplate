package lk.spacewa.boilerplate.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import dagger.hilt.android.scopes.ActivityScoped
import lk.spacewa.boilerplate.GetPokemonsQuery
import lk.spacewa.boilerplate.data.DataManager
import lk.spacewa.boilerplate.ui.base.BaseViewModel
import lk.spacewa.boilerplate.utils.SingleLiveEvent
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider
import timber.log.Timber

/**
 * Created by Imdad on 05/11/20.
 */

// ActivityScoped annotation will allow the view model to be reused by multiple fragments pertaining to the activity
@ActivityScoped
class HomeViewModel @ViewModelInject constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel(dataManager, schedulerProvider) {

    var pokemonDataEvent: SingleLiveEvent<GetPokemonsQuery.Data> = SingleLiveEvent()


    fun getPokemonInfo() {
        compositeDisposable.add(dataManager?.getPokemons()?.subscribe(
                { pokemonDataEvent.value = it.data; },
                { throwable -> Timber.e(throwable) }
        ))
    }
}