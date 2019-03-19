/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.service.deserializer

import com.google.gson.*
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.lang.reflect.Type

class DateTimeDeserializer : JsonDeserializer<DateTime>, JsonSerializer<DateTime> {

    companion object {
        const val DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ" //"2009-04-02T04:51:54Z"
        const val DATETIME_PRETTY_FORMAT = "dd MMMM yyyy"
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): DateTime {
        val formatter = DateTimeFormat.forPattern(DATETIME_FORMAT)
        return formatter.parseDateTime(json.asString)
    }

    override fun serialize(src: DateTime?, typeOfSrc: Type, context: JsonSerializationContext): JsonElement? {
        return if (src == null) null else JsonPrimitive(src.toString())
    }

}

