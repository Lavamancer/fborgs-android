package com.jalbarracin.flexappealtest.controller.adapter

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.model.Owner
import com.jalbarracin.flexappealtest.service.tool.BrowserTool
import kotlinx.android.synthetic.main.item_contributor.view.*


class ContributorsAdapter(
    activity: Activity,
    list: MutableList<Owner>
) : CustomBaseAdapter<Owner, ContributorsAdapter.Holder>(activity, list, R.layout.item_contributor, Holder::class.java) {


    class Holder(view: View) {
        var nameTextView: TextView = view.nameTextView
        var avatarImageView: ImageView = view.avatarImageView
        var contributionsTextView: TextView = view.contributionsTextView
        var urlTextView: TextView = view.urlTextView
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val owner: Owner = list[position]

        holder.nameTextView.text = owner.login
        holder.contributionsTextView.text = "${owner.contributions}"
        holder.urlTextView.text = owner.htmlUrl
        holder.urlTextView.setOnClickListener {
            BrowserTool.show(activity, owner.htmlUrl)
        }
        if (owner.avatarUrl != null) {
            Glide.with(activity).load(owner.avatarUrl).into(holder.avatarImageView)
        }
    }

}
