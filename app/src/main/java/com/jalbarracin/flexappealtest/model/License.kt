package com.jalbarracin.flexappealtest.model

import java.io.Serializable


data class License(
    var key: String? = null,
    var name: String? = null,
    var spdxId: String? = null
): Serializable