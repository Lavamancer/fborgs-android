package com.jalbarracin.flexappealtest.controller

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jalbarracin.flexappealtest.R
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Observable.timer(0, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .doOnNext {
//                    FakerTool.load()
                }
                .subscribe {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                }
    }
}
