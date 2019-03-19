/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.model.response

import com.jalbarracin.flexappealtest.model.Repository
import java.io.Serializable


data class GithubResponse(
    var totalCount: Int,
    var incompleteResults: Boolean,
    var items: List<Repository>
): Serializable