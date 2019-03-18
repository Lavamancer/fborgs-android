package com.jalbarracin.flexappealtest.model

import com.github.javafaker.Faker
import java.io.Serializable


data class Document (
        var id: Long? = null,
        var name: String? = null,
        var baseName: String? = null,
        var extension: String? = null,
        var description: String? = null,
        var type: String? = null,
        var tag: String? = null,
        var url: String? = null
): Serializable {

    companion object {

        fun mock(@Suppress("UNUSED_PARAMETER") faker: Faker, i: Int): Document {
            var document = Document()
            document.id = i + 1L
            document.url = "https://picsum.photos/200/300?image=$i"
            return document
        }

        fun mockList(faker: Faker, count: Int): ArrayList<Document> {
            var list = ArrayList<Document>()
            for (i in 0..count) {
                list.add(mock(faker, i))
            }
            return list
        }

    }
}