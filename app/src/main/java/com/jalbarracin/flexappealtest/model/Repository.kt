/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.model

import org.joda.time.DateTime
import java.io.Serializable


data class Repository (

    var id: Long? = null,
    var nodeId: String? = null,
    var name: String? = null,
    var fullName: String? = null,
    var private: Boolean? = null,
    var owner: Owner? = null,
    var htmlUrl: String? = null,
    var description: String? = null,
    var fork: Boolean? = null,
    var url: String? = null,
    var createdAt: DateTime? = null,
    var updatedAt: DateTime? = null,
    var pushedAt: DateTime? = null,
    var size: Int? = null,
    var stargazersCount: Int? = null,
    var watchersCount: Int? = null,
    var language: String? = null,
    var hasIssues: Boolean? = null,
    var hasProjects: Boolean? = null,
    var hasDownloads: Boolean? = null,
    var hasWiki: Boolean? = null,
    var hasPages: Boolean? = null,
    var forksCount: Int? = null,
    var archived: Boolean? = null,
    var forks: Int? = null,
    var openIssues: Int? = null,
    var watchers: Int? = null,
    var defaultBranch: String? = null,
    var permissions: Map<String, Boolean>? = null,
    var license: License? = null,
    var homepage: String? = null,
    var score: Float? = null

    ): Serializable {

    companion object {
        const val KEY = "repository"
    }
}

/*
  {
    "id": 165883,
    "node_id": "MDEwOlJlcG9zaXRvcnkxNjU4ODM=",
    "name": "codemod",
    "full_name": "facebook/codemod",
    "private": false,
    "owner": { ... },
    "html_url": "https://github.com/facebook/codemod",
    "description": "Codemod is a tool/library to assist you with large-scale codebase refactors that can be partially automated but still require human oversight and occasional intervention. Codemod was developed at Facebook and released as open source.",
    "fork": false,
    "url": "https://api.github.com/repos/facebook/codemod",
                "forks_url": "https://api.github.com/repos/facebook/codemod/forks",
                "keys_url": "https://api.github.com/repos/facebook/codemod/keys{/key_id}",
                "collaborators_url": "https://api.github.com/repos/facebook/codemod/collaborators{/collaborator}",
                "teams_url": "https://api.github.com/repos/facebook/codemod/teams",
                "hooks_url": "https://api.github.com/repos/facebook/codemod/hooks",
                "issue_events_url": "https://api.github.com/repos/facebook/codemod/issues/events{/number}",
                "events_url": "https://api.github.com/repos/facebook/codemod/events",
                "assignees_url": "https://api.github.com/repos/facebook/codemod/assignees{/user}",
                "branches_url": "https://api.github.com/repos/facebook/codemod/branches{/branch}",
                "tags_url": "https://api.github.com/repos/facebook/codemod/tags",
                "blobs_url": "https://api.github.com/repos/facebook/codemod/git/blobs{/sha}",
                "git_tags_url": "https://api.github.com/repos/facebook/codemod/git/tags{/sha}",
                "git_refs_url": "https://api.github.com/repos/facebook/codemod/git/refs{/sha}",
                "trees_url": "https://api.github.com/repos/facebook/codemod/git/trees{/sha}",
                "statuses_url": "https://api.github.com/repos/facebook/codemod/statuses/{sha}",
                "languages_url": "https://api.github.com/repos/facebook/codemod/languages",
                "stargazers_url": "https://api.github.com/repos/facebook/codemod/stargazers",
                "contributors_url": "https://api.github.com/repos/facebook/codemod/contributors",
                "subscribers_url": "https://api.github.com/repos/facebook/codemod/subscribers",
                "subscription_url": "https://api.github.com/repos/facebook/codemod/subscription",
                "commits_url": "https://api.github.com/repos/facebook/codemod/commits{/sha}",
                "git_commits_url": "https://api.github.com/repos/facebook/codemod/git/commits{/sha}",
                "comments_url": "https://api.github.com/repos/facebook/codemod/comments{/number}",
                "issue_comment_url": "https://api.github.com/repos/facebook/codemod/issues/comments{/number}",
                "contents_url": "https://api.github.com/repos/facebook/codemod/contents/{+path}",
                "compare_url": "https://api.github.com/repos/facebook/codemod/compare/{base}...{head}",
                "merges_url": "https://api.github.com/repos/facebook/codemod/merges",
                "archive_url": "https://api.github.com/repos/facebook/codemod/{archive_format}{/ref}",
                "downloads_url": "https://api.github.com/repos/facebook/codemod/downloads",
                "issues_url": "https://api.github.com/repos/facebook/codemod/issues{/number}",
                "pulls_url": "https://api.github.com/repos/facebook/codemod/pulls{/number}",
                "milestones_url": "https://api.github.com/repos/facebook/codemod/milestones{/number}",
                "notifications_url": "https://api.github.com/repos/facebook/codemod/notifications{?since,all,participating}",
                "labels_url": "https://api.github.com/repos/facebook/codemod/labels{/name}",
                "releases_url": "https://api.github.com/repos/facebook/codemod/releases{/id}",
                "deployments_url": "https://api.github.com/repos/facebook/codemod/deployments",
    "created_at": "2009-04-02T04:51:54Z",
    "updated_at": "2019-03-16T12:54:40Z",
    "pushed_at": "2018-10-04T12:06:24Z",
                "git_url": "git://github.com/facebook/codemod.git",
                "ssh_url": "git@github.com:facebook/codemod.git",
                "clone_url": "https://github.com/facebook/codemod.git",
                "svn_url": "https://github.com/facebook/codemod",
                "homepage": "",
    "size": 97,
    "stargazers_count": 2772,
    "watchers_count": 2772,
    "language": "Python",
    "has_issues": true,
    "has_projects": true,
    "has_downloads": true,
    "has_wiki": false,
    "has_pages": false,
    "forks_count": 146,
                "mirror_url": null,
    "archived": false,
    "open_issues_count": 12,
                "license": {
                  "key": "apache-2.0",
                  "name": "Apache License 2.0",
                  "spdx_id": "Apache-2.0",
                  "url": "https://api.github.com/licenses/apache-2.0",
                  "node_id": "MDc6TGljZW5zZTI="
                },
    "forks": 146,
    "open_issues": 12,
    "watchers": 2772,
    "default_branch": "master",
    "permissions": {
      "admin": false,
      "push": false,
      "pull": true
    }
 */