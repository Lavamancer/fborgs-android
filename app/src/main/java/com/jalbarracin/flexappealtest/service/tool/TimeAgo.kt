package com.jalbarracin.flexappealtest.service.tool

import org.joda.time.DateTime
import java.util.*
import java.util.concurrent.TimeUnit

object TimeAgo {

    val times: MutableMap<String, Long> = mutableMapOf()

    init {
        times["year"] = TimeUnit.DAYS.toMillis(365)
        times["month"] = TimeUnit.DAYS.toMillis(30)
        times["week"] = TimeUnit.DAYS.toMillis(7)
        times["day"] = TimeUnit.DAYS.toMillis(1)
        times["hour"] = TimeUnit.HOURS.toMillis(1)
        times["minute"] = TimeUnit.MINUTES.toMillis(1)
        times["second"] = TimeUnit.SECONDS.toMillis(1)
    }

    fun toRelative(duration: Long, maxLevel: Int): String {
        var duration = duration
        val res = StringBuilder()
        var level = 0
        for (time in times.entries) {
            val timeDelta = duration / time.value
            if (timeDelta > 0) {
                res.append(timeDelta)
                    .append(" ")
                    .append(time.key)
                    .append(if (timeDelta > 1) "s" else "")
                    .append(", ")
                duration -= time.value * timeDelta
                level++
            }
            if (level == maxLevel) {
                break
            }
        }
        if ("" == res.toString()) {
            return "0 seconds ago"
        } else {
            res.setLength(res.length - 2)
            res.append(" ago")
            return res.toString()
        }
    }

    fun toRelative(dateTime: DateTime): String {
        return toRelative(dateTime.toDate(), DateTime.now().toDate(), 1)
    }

    fun toRelative(duration: Long): String {
        return toRelative(duration, times.size)
    }

    fun toRelative(start: Date, end: Date): String {
        assert(start.after(end))
        return toRelative(end.getTime() - start.getTime())
    }

    fun toRelative(start: Date, end: Date, level: Int): String {
        assert(start.after(end))
        return toRelative(end.getTime() - start.getTime(), level)
    }
}