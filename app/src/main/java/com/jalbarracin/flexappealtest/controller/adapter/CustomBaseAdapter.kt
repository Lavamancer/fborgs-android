/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.controller.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

abstract class CustomBaseAdapter<T, VH>(
        var activity: Activity,
        var list: MutableList<T>,
        var itemResource: Int,
        var holderClass: Class<VH>
) : BaseAdapter() {

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    fun refresh(list: List<T>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun update(list: List<T>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): Any? {
        return if (list.isEmpty()) {
            null
        } else {
            list[i]
        }
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val view: View
        val holder: VH
        if (convertView == null) {
            view = LayoutInflater.from(activity).inflate(itemResource, viewGroup, false)
            holder = holderClass.getConstructor(View::class.java).newInstance(view)
            view.tag = holder
        } else {
            view = convertView
            @Suppress("UNCHECKED_CAST")
            holder = convertView.tag as VH
        }
        onBindViewHolder(holder, position)
        return view
    }

    abstract fun onBindViewHolder(holder: VH, position: Int)

}
