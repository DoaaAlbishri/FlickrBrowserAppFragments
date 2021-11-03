package com.example.flickrbrowserappfragments

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(private val main: MainFragment, private val images: ArrayList<Image>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    var ctx: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        ctx= parent.context
        return ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_row, parent, false
                )
        )
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val image=images[position]

        holder.itemView.apply{
            tvImage.text= image.title
            Glide.with(this)
                .load(image.link)
                .into(ivImage)
            llItem.setOnClickListener {
             //   ctx!!.startActivity(Intent(ctx,com.example.flickrbrowserappfragments.Glide::class.java)
            //            .putExtra("link",image.link))
                with(main.sharedPreferences.edit()) {
                    putString("link",image.link)
                    apply()
                }
            //nav to glide fragment
            main!!.findNavController().navigate(R.id.action_mainFragment_to_glideFragment)

            }
        }

    }
    override fun getItemCount(): Int =images.size
}