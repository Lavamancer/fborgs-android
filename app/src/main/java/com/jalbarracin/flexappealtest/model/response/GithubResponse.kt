package com.jalbarracin.flexappealtest.model.response

import com.google.gson.annotations.SerializedName
import com.jalbarracin.flexappealtest.model.Repository
import java.io.Serializable


data class GithubResponse(
    @SerializedName("total_count")
    var totalCount: Int,
    @SerializedName("incomplete_results")
    var incompleteResults: Boolean,
    var items: List<Repository>
): Serializable