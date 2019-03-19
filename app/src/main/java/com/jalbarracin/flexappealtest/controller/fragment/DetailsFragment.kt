package com.jalbarracin.flexappealtest.controller.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.controller.RepositoryActivity
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
        updatedAtTextView.text = "Updated on ${repository.updatedAt!!.toString("dd MMMM yyyy", Locale.ENGLISH)}"
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
        licenseTextView.text = repository.license!!.name
        scoreTextView.text = "${repository.score}"
        homepageTextView.text = repository.homepage
        homepageTextView.setOnClickListener {
            BrowserTool.show(activity, repository.homepage)
        }
        sizeTextView.text = "${repository.size}"
    }
}