package com.example.submision1made2019.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.example.submision1made2019.R
import com.example.submision1made2019.adapter.AdapterPager
import com.example.submision1made2019.ui.fragment.FragmentMovie
import com.example.submision1made2019.ui.fragment.FragmentTVShows
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.vPager_main)
        tabLayout = findViewById(R.id.tab_main)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupViewPager(pager: ViewPager) {
        val adapter = supportFragmentManager.let {
            AdapterPager(it)
        }

        val tvShows = FragmentTVShows.tvIntance()
        adapter.addFragment(tvShows, "TV Shows")
        val movies = FragmentMovie.movieIntance()
        adapter.addFragment(movies, "Movies")
        pager.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this, Settings::class.java))
        return true
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
