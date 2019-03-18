package com.jalbarracin.flexappealtest.service

import com.github.javafaker.Faker


object FakerTool {

    var faker = Faker()

    fun load() {
        println("Faker loaded $faker")
    }

}