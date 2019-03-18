package com.jalbarracin.flexappealtest.service.tool

import com.github.javafaker.Faker


object FakerTool {

    var faker = Faker()

    fun load() {
        println("Faker loaded $faker")
    }

}