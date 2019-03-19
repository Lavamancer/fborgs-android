/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest


class Application : android.app.Application() {

    companion object {
        lateinit var session: Session
    }

    override fun onCreate() {
        super.onCreate()
        session = Session.create(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Session.store(this, session)
    }

}