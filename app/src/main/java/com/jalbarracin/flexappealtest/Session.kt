package com.jalbarracin.flexappealtest

import android.app.Application
import com.jalbarracin.flexappealtest.service.StorageTool
import java.io.Serializable


class Session : Serializable {

    var name: String? = null


    companion object {

        fun create(application: Application): Session {
            val session: Session? = StorageTool.load(application, "SESSION")
            return session ?: Session()
        }

        fun store(application: Application, session: Session) {
            StorageTool.store(application, session, "SESSION")
        }

    }

}