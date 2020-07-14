package lk.spacewa.boilerplate.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import lk.spacewa.boilerplate.BR
import lk.spacewa.boilerplate.R
import lk.spacewa.boilerplate.base.BaseActivity
import lk.spacewa.boilerplate.databinding.ActivityHomeBinding

/**
 * Created by Imdad on 05/11/20.
 */
//Should use AndroidEntryPoint annotation to tell Hilt where you need to inject the modules, typically used in Activities and fragments
@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding?, HomeViewModel?>() {

    //when using the same instance of the HomeViewModel in a fragment you can initiate it by using the following code in the fragment
    //private val mHomeViewModel: HomeViewModel by activityViewModels()
    private val mHomeViewModel: HomeViewModel by viewModels()

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_home

    override val viewModel: HomeViewModel?
        get() {
            return mHomeViewModel
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel?.getPokemonInfo()
        viewModel?.pokemonDataEvent?.observe(this, Observer {
            val homeRvAdapter = HomeRvAdapter(it.pokemons()!!, this@HomeActivity)
            val layoutManager = LinearLayoutManager(this@HomeActivity)
            viewDataBinding?.rvPokemonDetails?.setLayoutManager(layoutManager)
            viewDataBinding?.rvPokemonDetails?.adapter = homeRvAdapter
        })


    }


}