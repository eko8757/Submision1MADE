package com.example.submision1made_gdk2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.submision1made2019.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.custom_dialog.*
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity() {

    var items: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //passing data
        val i = intent
        items = i.getParcelableExtra("name")
        Log.d("Test Parcelable", items.toString())

        title_detail?.text = items?.name
        tv_director.text = items?.director
        tv_screenplay.text = items?.screenplay
        tv_story.text = items?.story
        tv_overview.text = items?.overview
        Picasso.get().load(items?.image!!).into(img_detail)

        //add to favorite
        img_favorite.setOnClickListener {
            toast("Add to Favorite")
        }

        //add to watchlist
        img_watchlist.setOnClickListener {
            toast("Add to Watchlist")
        }

        //rate movie
        img_rate.setOnClickListener {
            toast("Rate")
        }
    }
}
