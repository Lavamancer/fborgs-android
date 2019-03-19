package com.jalbarracin.flexappealtest.controller.adapter

import android.app.Activity
import android.view.View
import android.widget.TextView
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.model.Issue
import kotlinx.android.synthetic.main.item_issue.view.*


class IssuesAdapter(
    activity: Activity,
    list: MutableList<Issue>
) : CustomBaseAdapter<Issue, IssuesAdapter.Holder>(activity, list, R.layout.item_issue, Holder::class.java) {


    class Holder(view: View) {
        var titleTextView: TextView = view.titleTextView
        var commentsTextView: TextView = view.commentsTextView
        var authorTextView: TextView = view.authorTextView
        var bodyTextView: TextView = view.bodyTextView
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val issue: Issue = list[position]

        holder.titleTextView.text = issue.title
        holder.commentsTextView.text = "${issue.comments}"
        holder.authorTextView.text = issue.user!!.login
        holder.bodyTextView.text = issue.body
    }

}