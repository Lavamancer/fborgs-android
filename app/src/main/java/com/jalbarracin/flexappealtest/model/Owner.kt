package com.jalbarracin.flexappealtest.model

import java.io.Serializable


class Owner (
    var login: String? = null,
    var id: Long? = null,
    var nodeId: String? = null,
    var avatarUrl: String? = null,
    var gravatarId: String? = null,
    var url: String? = null,
    var htmlUrl: String? = null,
    var followersUrl: String? = null,
    var followingUrl: String? = null,
    var gistsUrl: String? = null,
    var starredUrl: String? = null,
    var subscriptionsUrl: String? = null,
    var organizationsUrl: String? = null,
    var reposUrl: String? = null,
    var eventsUrl: String? = null,
    var receivedEventsUrl: String? = null,
    var type: String? = null,
    var siteAdmin: Boolean? = null,
    var contributions: Int? = null
): Serializable

/*
    "login": "facebook",
    "id": 69631,
    "node_id": "MDEyOk9yZ2FuaXphdGlvbjY5NjMx",
    "avatar_url": "https://avatars3.githubusercontent.com/u/69631?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/facebook",
    "html_url": "https://github.com/facebook",
    "followers_url": "https://api.github.com/users/facebook/followers",
    "following_url": "https://api.github.com/users/facebook/following{/other_user}",
    "gists_url": "https://api.github.com/users/facebook/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/facebook/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/facebook/subscriptions",
    "organizations_url": "https://api.github.com/users/facebook/orgs",
    "repos_url": "https://api.github.com/users/facebook/repos",
    "events_url": "https://api.github.com/users/facebook/events{/privacy}",
    "received_events_url": "https://api.github.com/users/facebook/received_events",
    "type": "Organization",
    "site_admin": false
 */