package com.example.submision1made_gdk2019

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.submision1made2019.R

class MoviewAdapter(private var context: Context, private var dataMovie: ArrayList<Item>): BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val viewHolder = view?.let { ViewHolder(it) }
        val item = getItem(position) as Item
        viewHolder?.bindItem(item)
        return view
    }

    override fun getItem(position: Int): Any {
        return dataMovie[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataMovie.size
    }

    inner class ViewHolder(view: View){
        val titleMovie = view.findViewById<TextView>(R.id.txt_name)
        val nameDirector = view.findViewById<TextView>(R.id.txt_name_director)
        val nameScreenplay = view.findViewById<TextView>(R.id.txt_name_screenplay)
        val nameStory = view.findViewById<TextView>(R.id.txt_name_story)
        val images = view.findViewById<ImageView>(R.id.image_list)

        fun bindItem(item: Item) {
            titleMovie.text = item.name
            nameDirector.text = item.director
            nameScreenplay.text = item.screenplay
            nameStory.text = item.story
            images.setImageResource(item.image!!)
        }
    }
}