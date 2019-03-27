/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.service.tool

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.jalbarracin.flexappealtest.R


object BrowserTool {


    fun show(activity: Activity, url: String?) {
        if (url == null || url.isEmpty()) {
            println("It's not a valid url to open with a browser")
            return
        }
        try {
            val webPage = Uri.parse(url)
            activity.startActivity(Intent(Intent.ACTION_VIEW, webPage))
        } catch (e: Exception) {
            Toast.makeText(activity, activity.getString(R.string.browser_not_installed), Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }

    }


}