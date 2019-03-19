/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest

import com.jalbarracin.flexappealtest.service.tool.ColorTool
import org.junit.Assert
import org.junit.Test


class ColorToolUnitTest {

    @Test
    fun colorTool_CheckSomeLanguages() {
        Assert.assertEquals(ColorTool.getColorResourceByText("JavaScript"), ColorTool.yellowColor)
        Assert.assertEquals(ColorTool.getColorResourceByText("Java"), ColorTool.greenColor)
        Assert.assertEquals(ColorTool.getColorResourceByText("Objective-C++"), ColorTool.orangeColor)
        Assert.assertEquals(ColorTool.getColorResourceByText("OCaml"), ColorTool.pinkColor)
        Assert.assertEquals(ColorTool.getColorResourceByText("C"), ColorTool.purpleColor)
    }

}
