package lk.spacewa.boilerplate.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import lk.spacewa.boilerplate.GetPokemonsQuery
import lk.spacewa.boilerplate.R
import lk.spacewa.boilerplate.databinding.ItemPokemonDetailsBinding

class HomeRvAdapter(myDataset: List<GetPokemonsQuery.Pokemon>, context: Context) : RecyclerView.Adapter<HomeRvAdapter.ViewHolder?>() {
    private val mDataset: List<GetPokemonsQuery.Pokemon> = myDataset
    private val mContext: Context = context


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRvAdapter.ViewHolder {
        // create a new view
        val layoutInflater = LayoutInflater.from(parent.context)
        // set the view's size, margins, paddings and layout parameters
        val binding: ItemPokemonDetailsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_pokemon_details, parent, false)
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        initRecyclerView(holder, position)
    }

    private fun initRecyclerView(holder: ViewHolder, position: Int) {
        val pokemon: GetPokemonsQuery.Pokemon = mDataset[position]

        var requestOptions = RequestOptions()
        requestOptions = requestOptions
                .transforms(CenterCrop(), RoundedCorners(16))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)

        Glide.with(mContext)
                .load(pokemon.image())
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(requestOptions)
                .into(holder.mBinding.imgPokemon)

        holder.mBinding.tvPokemon.text = pokemon.name()

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder(itemBinding: ItemPokemonDetailsBinding) : RecyclerView.ViewHolder(itemBinding.getRoot()), View.OnClickListener {
        // each data item is just a string in this case
        val mBinding: ItemPokemonDetailsBinding = itemBinding
        override fun onClick(v: View) {}

    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
}