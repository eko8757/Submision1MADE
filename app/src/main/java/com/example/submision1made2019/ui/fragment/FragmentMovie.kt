package com.example.submision1made2019.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.submision1made2019.R
import com.example.submision1made_gdk2019.DetailActivity
import com.example.submision1made_gdk2019.Item
import com.example.submision1made_gdk2019.MovieAdapter
import org.jetbrains.anko.support.v4.intentFor

class FragmentMovie : Fragment() {

    lateinit var mAdapter: MovieAdapter
    lateinit var recyclerView: RecyclerView
    private var itemList: MutableList<Item> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_movie, container, false)
        recyclerView = view.findViewById(R.id.recyclerView_moview)
        initData()
        mAdapter = MovieAdapter(itemList) {
            startActivity(intentFor<DetailActivity>("name" to it))
        }
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
        return view
    }

    private fun initData() {
        val title = resources.getStringArray(R.array.movie_name)
        val desc = resources.getStringArray(R.array.overview_movie)
        val nameDirector = resources.getStringArray(R.array.director)
        val nameScreenPlay = resources.getStringArray(R.array.screenplay)
        val nameStroy = resources.getStringArray(R.array.stroy)
        val image = resources.obtainTypedArray(R.array.movie_poster)

        for (i in title.indices) {
            itemList.add(Item(title[i], desc[i], nameDirector[i], nameScreenPlay[i], nameStroy[i], image.getResourceId(i,0)))
        }
    }

    companion object {
        fun movieIntance(): FragmentMovie = FragmentMovie()
    }

}
