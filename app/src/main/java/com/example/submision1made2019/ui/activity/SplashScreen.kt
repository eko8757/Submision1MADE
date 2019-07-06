package com.example.submision1made_gdk2019

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.submision1made2019.ui.activity.MainActivity
import com.example.submision1made2019.R
import org.jetbrains.anko.*

class SplashScreen: AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private var SPLASH_DELAY: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashUI().setContentView(this)

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

    //anko layout
    class splashUI : AnkoComponent<SplashScreen> {
        override fun createView(ui: AnkoContext<SplashScreen>) = with(ui) {
            relativeLayout {
                setBackgroundResource(R.color.colorPrimaryDark)
                imageView(R.drawable.film_reel).lparams(width = matchParent) {
                    centerInParent()
                    width = dip(152)
                    height = dip(160)
                }
            }
        }
    }

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()

        }
    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

}