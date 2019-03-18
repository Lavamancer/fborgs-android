package com.jalbarracin.flexappealtest.service

import com.google.gson.*
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.lang.reflect.Type

class DateTimeDeserializer : JsonDeserializer<DateTime>, JsonSerializer<DateTime> {

    companion object {
        const val DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ" //"2009-04-02T04:51:54Z"
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

