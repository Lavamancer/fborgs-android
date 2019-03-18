package com.jalbarracin.flexappealtest.controller

import android.app.Activity
import android.os.Bundle
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.model.Repository


class RepositoryActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)
        configureViews()
    }

    private fun configureViews() {
        val repository: Repository = intent.getSerializableExtra("repository") as Repository
//        if (event.image != null) {
//            imageView.visibility = View.VISIBLE
//            Glide.with(this).load(event.image!!.url).into(imageView)
//        } else {
//            imageView.visibility = View.GONE
//        }
//        linearLayout.setOnClickListener {
//            Toast.makeText(this, "Hello Browser", Toast.LENGTH_SHORT).show()
//        }
//        titleTextView.text = event.title
//        titleTextView.maxLines = 2
//        authorTextView.text = event.author ?: "System"
//        dateTextView.text = event.date!!.toString("dd/MM/yyyy")
//        contentTextView.text = event.content
    }

}