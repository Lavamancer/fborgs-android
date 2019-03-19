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


//    fun share(activity: Activity, title: String, body: String, url: String) {
//        try {
//            val i = Intent(Intent.ACTION_SEND)
//            i.type = "text/plain"
//            i.putExtra(Intent.EXTRA_SUBJECT, title)
//            var sAux = "\n" + body + "\n\n"
//            sAux = sAux + url
//            i.putExtra(Intent.EXTRA_TEXT, sAux)
//            activity.startActivity(Intent.createChooser(i, "Elige una opción"))
//        } catch (e: Exception) {
//            Toast.makeText(activity, "No se pudo compartir el enlace", Toast.LENGTH_SHORT).show()
//            e.printStackTrace()
//        }
//    }

}