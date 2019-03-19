/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest

import android.app.Application
import com.jalbarracin.flexappealtest.service.tool.StorageTool
import java.io.Serializable


class Session : Serializable {

    var name: String? = null


    companion object {

        private const val KEY_SESSION = "SESSION"

        fun create(application: Application): Session {
            val session: Session? = StorageTool.load(application, KEY_SESSION)
            return session ?: Session()
        }

        fun store(application: Application, session: Session) {
            StorageTool.store(application, session, KEY_SESSION)
        }

    }

}