/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.model

import java.io.Serializable


data class License(
    var key: String? = null,
    var name: String? = null,
    var spdxId: String? = null
): Serializable