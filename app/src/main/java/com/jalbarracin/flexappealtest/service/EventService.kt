package com.jalbarracin.flexappealtest.service

import android.app.Activity
import android.widget.BaseAdapter
import com.jalbarracin.flexappealtest.controller.ProgressBarController
import com.jalbarracin.flexappealtest.model.Event
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object EventService {

    fun getEvents(activity: Activity, adapter: BaseAdapter, list: ArrayList<Event>) {
        val dialog = ProgressBarController.create(activity)
        dialog.show()
        Observable.fromCallable {
            Thread.sleep(1000)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    list.clear()
                    list.addAll(Event.mockList(FakerTool.faker, 30))
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
    }

}