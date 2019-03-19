/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.service.tool

import com.github.javafaker.Faker


object FakerTool {

    var faker = Faker()

    fun load() {
        println("Faker loaded $faker")
    }

}