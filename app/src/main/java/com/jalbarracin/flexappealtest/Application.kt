package com.jalbarracin.flexappealtest


class Application : android.app.Application() {

    companion object {
        lateinit var session: Session
    }

    override fun onCreate() {
        super.onCreate()
        session =
            Session.create(this)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Session.store(
            this,
            session
        )
    }

}