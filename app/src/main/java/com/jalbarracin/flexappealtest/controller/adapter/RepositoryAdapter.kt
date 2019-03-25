/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.controller.adapter

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.controller.RepositoryActivity
import com.jalbarracin.flexappealtest.model.Repository
import com.jalbarracin.flexappealtest.service.deserializer.DateTimeDeserializer
import com.jalbarracin.flexappealtest.service.tool.ColorTool
import kotlinx.android.synthetic.main.item_repository.view.*
import net.steamcrafted.materialiconlib.MaterialIconView
import java.util.*

class RepositoryAdapter(
        activity: Activity,
        list: MutableList<Repository>
) : CustomBaseAdapter<Repository, RepositoryAdapter.Holder>(activity, list, R.layout.item_repository, Holder::class.java) {

    var searchText: String? = null


    class Holder(view: View) {
        var linearLayout: LinearLayout = view.linearLayout
        var nameTextView: TextView = view.nameTextView
        var fullNameTextView: TextView = view.fullNameTextView
        var updatedAtTextView: TextView = view.updatedAtTextView
        var descriptionTextView: TextView = view.descriptionTextView
        var languageIconView: MaterialIconView = view.languageIconView
        var languageTextView: TextView = view.languageTextView
        var watchersTextView: TextView = view.watchersTextView
        var forksTextView: TextView = view.forksTextView
        var openIssuesTextView: TextView = view.openIssuesTextView
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val repository: Repository = list[position]

        holder.nameTextView.text = repository.name
        holder.fullNameTextView.text = repository.fullName

        if (repository.updatedAt != null) {
            val updatedAt = activity.getString(R.string.updated_on) + " ${repository.updatedAt!!.toString(DateTimeDeserializer.DATETIME_PRETTY_FORMAT, Locale.ENGLISH)}"
            holder.updatedAtTextView.visibility = View.VISIBLE
            holder.updatedAtTextView.text = updatedAt
        } else {
            holder.updatedAtTextView.visibility = View.GONE
        }
        holder.descriptionTextView.text = repository.description

        if (repository.language == null) {
            holder.languageIconView.visibility = View.GONE
        } else {
            holder.languageIconView.visibility = View.VISIBLE
            holder.languageTextView.text = repository.language
            holder.languageIconView.setColorResource(ColorTool.getColorResourceByText(repository.language))
        }

        holder.watchersTextView.text = repository.watchers.toString()
        holder.forksTextView.text = repository.forks.toString()
        holder.openIssuesTextView.text = repository.openIssues.toString()

        holder.linearLayout.setOnClickListener {
            val intent = Intent(activity, RepositoryActivity::class.java)
            intent.putExtra(Repository.KEY, repository)
            activity.startActivity(intent)
        }
    }

}