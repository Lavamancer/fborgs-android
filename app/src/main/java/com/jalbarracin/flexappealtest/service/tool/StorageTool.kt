/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.service.tool

import android.content.Context
import android.content.Context.MODE_PRIVATE
import java.io.*


object StorageTool {

    fun <T : Serializable> load(context: Context, path: String): T? {
        val file = File(context.getDir("data", Context.MODE_PRIVATE), path)
        println("Loading object " + path + " with " + file.length() + " bytes")
        if (file.length() > 0) {
            val ois: ObjectInputStream
            try {
                ois = ObjectInputStream(FileInputStream(file))
                val o = ois.readObject()
                ois.close()
                @Suppress("UNCHECKED_CAST")
                return o as T
            } catch (e: Exception) {
                println("Serialized object cannot be readed: $path")
                e.printStackTrace()
                file.delete()
            }

        }
        return null
    }

    fun store(context: Context, serializable: Serializable, path: String) {
        val file = File(context.getDir("data", MODE_PRIVATE), path)
        println("Storing object " + path + " with " + file.length() + " bytes")
        val outputStream: ObjectOutputStream
        try {
            outputStream = ObjectOutputStream(FileOutputStream(file))
            outputStream.writeObject(serializable)
            outputStream.flush()
            outputStream.close()
        } catch (e: Exception) {
            println("Serialized object cannot be stored: $path")
            e.printStackTrace()
            file.delete()
        }

    }
}