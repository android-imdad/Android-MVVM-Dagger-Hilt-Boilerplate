package lk.spacewa.boilerplate.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import lk.spacewa.boilerplate.BR
import lk.spacewa.boilerplate.R
import lk.spacewa.boilerplate.base.BaseActivity
import lk.spacewa.boilerplate.databinding.ActivityHomeBinding

/**
 * Created by Imdad on 05/11/20.
 */
@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding?, HomeViewModel?>() {

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

        })
    }


}