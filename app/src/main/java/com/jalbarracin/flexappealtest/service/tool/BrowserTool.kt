package com.jalbarracin.flexappealtest.service.tool

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast


object BrowserTool {


    fun show(activity: Activity?, url: String?) {
        if (url == null || url.isEmpty()) {
            println("It's not a valid url to open with a browser")
            return
        }
        try {
            val webPage = Uri.parse(url)
            activity!!.startActivity(Intent(Intent.ACTION_VIEW, webPage))
        } catch (e: Exception) {
            Toast.makeText(activity, "This action could not be performed. Please install a browser in your device.", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }

    }


}