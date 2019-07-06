package com.example.submision1made_gdk2019

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.submision1made2019.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class MovieAdapter(var items: List<Item>, val listener: (Item)-> Unit): RecyclerView.Adapter<MovieAdapter.CustomViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomViewholder {
        return CustomViewholder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CustomViewholder, position: Int) {
        holder.bindData(items[position], listener)
    }

    class CustomViewholder(view: View): RecyclerView.ViewHolder(view) {

        fun bindData(item: Item, listener: (Item) -> Unit) {
            itemView.txt_name.text = item.name
            itemView.txt_name_director.text = item.director
            itemView.txt_name_screenplay.text = item.screenplay
            itemView.txt_name_story.text = item.story
            Picasso.get().load(item.image!!).into(itemView.image_list)

            itemView.card_list.setBackgroundResource(R.drawable.bg_shadow_card)

            itemView.setOnClickListener {
                listener(item)
            }
        }
    }

}