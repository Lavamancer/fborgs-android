package com.jalbarracin.flexappealtest.model

import com.github.javafaker.Faker
import org.joda.time.DateTime
import java.io.Serializable

data class Event (
        var id: Long? = null,
        var title: String? = null,
        var image: Document? = null,
        var author: String? = null,
        var date: DateTime? = null,
        var content: String? = null
): Serializable {

    companion object {

        fun mock(faker: Faker, i: Int): Event {
            var event = Event()
            event.id = i + 1L
            event.title = faker.book().title()
            event.image = Document.mock(faker, i)
            event.author = faker.book().author()
            event.date = DateTime(faker.date().birthday(0, 1))
            event.content = faker.lorem().sentence(100, 50)
            return event
        }

        fun mockList(faker: Faker, count: Int): ArrayList<Event> {
            var list = ArrayList<Event>()
            for (i in 0..count) {
                list.add(mock(faker, i))
            }
            return list
        }

    }

}