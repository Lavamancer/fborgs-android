/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.service.tool


object ColorTool {

    var pinkColor: Int = com.jalbarracin.flexappealtest.R.color.pink
    var yellowColor: Int = com.jalbarracin.flexappealtest.R.color.yellow
    var brownColor: Int = com.jalbarracin.flexappealtest.R.color.brown
    var blueColor: Int = com.jalbarracin.flexappealtest.R.color.blue
    var cyanColor: Int = com.jalbarracin.flexappealtest.R.color.cyan
    var cyan2Color: Int = com.jalbarracin.flexappealtest.R.color.cyan2
    var greenColor: Int = com.jalbarracin.flexappealtest.R.color.green
    var purpleColor: Int = com.jalbarracin.flexappealtest.R.color.purple
    var redColor: Int = com.jalbarracin.flexappealtest.R.color.red
    var orangeColor: Int = com.jalbarracin.flexappealtest.R.color.orange

    var colorResources: MutableList<Int> = mutableListOf()
    init {
        colorResources.add(pinkColor)
        colorResources.add(yellowColor)
        colorResources.add(brownColor)
        colorResources.add(blueColor)
        colorResources.add(cyanColor)
        colorResources.add(cyan2Color)
        colorResources.add(greenColor)
        colorResources.add(purpleColor)
        colorResources.add(redColor)
        colorResources.add(orangeColor)
    }

    fun getColorResourceByText(text: String?): Int {
        return colorResources[Math.abs(text.hashCode() % colorResources.size)]
    }

}
