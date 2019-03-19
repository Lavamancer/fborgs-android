/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.model

import org.joda.time.DateTime
import java.io.Serializable


data class Issue(
    var title: String? = null,
    var user: Owner? = null,
    var createdAt: DateTime? = null,
    var updatedAt: DateTime? = null,
    var body: String? = null,
    var comments: Int? = null,
    var htmlUrl: String? = null

): Serializable


/*

    "url": "https://api.github.com/repos/facebook/react-native/issues/24020",
    "repository_url": "https://api.github.com/repos/facebook/react-native",
    "labels_url": "https://api.github.com/repos/facebook/react-native/issues/24020/labels{/name}",
    "comments_url": "https://api.github.com/repos/facebook/react-native/issues/24020/comments",
    "events_url": "https://api.github.com/repos/facebook/react-native/issues/24020/events",
    "html_url": "https://github.com/facebook/react-native/issues/24020",
    "id": 422482189,
    "node_id": "MDU6SXNzdWU0MjI0ODIxODk=",
    "number": 24020,
    "labels": [
      {
        "id": 1207189779,
        "node_id": "MDU6TGFiZWwxMjA3MTg5Nzc5",
        "url": "https://api.github.com/repos/facebook/react-native/labels/Type:%20Bug%20Report",
        "name": "Type: Bug Report",
        "color": "ffffff",
        "default": false
      },
      {
        "id": 992655625,
        "node_id": "MDU6TGFiZWw5OTI2NTU2MjU=",
        "url": "https://api.github.com/repos/facebook/react-native/labels/%F0%9F%93%A6Bundler",
        "name": "📦Bundler",
        "color": "fef2c0",
        "default": false
      }
    ],
    "state": "open",
    "locked": false,
    "milestone": null,
    "comments": 1,
    "created_at": "2019-03-18T23:45:03Z",
    "updated_at": "2019-03-19T00:01:46Z",
    "closed_at": null,
    "author_association": "NONE",
    "body": "I tried to compile a release build for android, the bundler would always error at the same point - unable to resolve"
 */