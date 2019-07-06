package com.example.submision1made2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.submision1made_gdk2019.DetailActivity
import com.example.submision1made_gdk2019.Item
import com.example.submision1made_gdk2019.MoviewAdapter
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MoviewAdapter
    lateinit var lisMoview: ArrayList<Item>
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lisMoview = ArrayList()
        adapter = MoviewAdapter(this, lisMoview)

        preparee()
        listView = findViewById(R.id.list_movie)
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            startActivity(intentFor<DetailActivity>("name" to lisMoview[i]))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            Toast.makeText(this@MainActivity, lisMoview.get(i).name, Toast.LENGTH_SHORT).show()
        }
        listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun preparee() {
        val dataTitle = resources.getStringArray(R.array.movie_name)
        val dataDirector = resources.getStringArray(R.array.director)
        val dataScreenplay = resources.getStringArray(R.array.screenplay)
        val dataStory = resources.getStringArray(R.array.stroy)
        val dataPhoto = resources.obtainTypedArray(R.array.movie_poster)
        val desc = resources.getStringArray(R.array.overview_movie)

        for (i in dataTitle.indices) {
            lisMoview.add(Item(dataTitle[i], desc[i], dataDirector[i], dataScreenplay[i], dataStory[i], dataPhoto.getResourceId(i,0)))
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this, R.style.MyDialogTheme)
        val view: View = layoutInflater.inflate(R.layout.custom_dialog, null)
        val btn1: Button = view.findViewById(R.id.btn_ya_exit)
        val btn2: Button = view.findViewById(R.id.btn_batal_exit)
        builder.setView(view)

        val alert: AlertDialog = builder.create()
        alert.show()

        btn1.setOnClickListener {
            toast("Keluar")
            finish()
        }

        btn2.setOnClickListener {
            toast("Batal")
            alert.dismiss()
        }
    }
}
