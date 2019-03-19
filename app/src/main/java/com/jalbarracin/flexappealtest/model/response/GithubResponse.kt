package com.jalbarracin.flexappealtest.model.response

import com.jalbarracin.flexappealtest.model.Repository
import java.io.Serializable


data class GithubResponse(
    var totalCount: Int,
    var incompleteResults: Boolean,
    var items: List<Repository>
): Serializable