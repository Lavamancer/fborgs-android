/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.controller.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.controller.RepositoryActivity
import com.jalbarracin.flexappealtest.service.deserializer.DateTimeDeserializer
import com.jalbarracin.flexappealtest.service.tool.BrowserTool
import com.jalbarracin.flexappealtest.service.tool.ColorTool
import kotlinx.android.synthetic.main.fragment_details.*
import java.util.*


class DetailsFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = (activity as RepositoryActivity).repository

        nameTextView.text = repository.name
        fullNameTextView.text = repository.fullName
        if (repository.updatedAt == null) {
            updatedAtTextView.visibility = View.VISIBLE
            val updatedAt = getString(R.string.updated_on) + " ${repository.updatedAt!!.toString(DateTimeDeserializer.DATETIME_PRETTY_FORMAT, Locale.ENGLISH)}"
            updatedAtTextView.text = updatedAt
        } else {
            updatedAtTextView.visibility = View.GONE
        }
        descriptionTextView.text = repository.description

        if (repository.language == null) {
            languageIconView.visibility = View.GONE
        } else {
            languageIconView.visibility = View.VISIBLE
            languageTextView.text = repository.language
            languageIconView.setColorResource(ColorTool.getColorResourceByText(repository.language))
        }

        watchersTextView.text = repository.watchers.toString()
        forksTextView.text = repository.forks.toString()
        openIssuesTextView.text = repository.openIssues.toString()
        defaultBranchTextView.text = repository.defaultBranch
        licenseTextView.text = if (repository.license == null) getString(R.string.details_nolicense) else repository.license!!.name
        scoreTextView.text = "${repository.score}"
        homepageTextView.text = repository.homepage
        homepageTextView.setOnClickListener {
            val activity = activity ?: return@setOnClickListener
            BrowserTool.show(activity, repository.homepage)
        }
        sizeTextView.text = "${repository.size}"
    }
}