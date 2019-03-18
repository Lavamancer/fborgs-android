package com.jalbarracin.flexappealtest.controller.adapter

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.model.Repository
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryAdapter(
        activity: Activity,
        list: List<Repository>
) : CustomBaseAdapter<Repository, RepositoryAdapter.Holder>(activity, list, R.layout.item_repository, Holder::class.java) {

    class Holder(view: View) {
        var linearLayout: LinearLayout = view.linearLayout
        var imageView: ImageView = view.imageView
        var titleTextView: TextView = view.titleTextView
        var authorTextView: TextView = view.authorTextView
        var dateTextView: TextView = view.dateTextView
        var contentTextView: TextView = view.contentTextView
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val repository: Repository = list[position]
//        if (event.image != null) {
//            holder.imageView.visibility = View.VISIBLE
//            Glide.with(activity).load(event.image!!.url).into(holder.imageView)
//        } else {
//            holder.imageView.visibility = View.GONE
//        }
//        holder.linearLayout.setOnClickListener {
//            val intent = Intent(activity, RepositoryActivity::class.java)
//            intent.putExtra("event", event)
//            activity.startActivity(intent)
//        }
        holder.titleTextView.text = "Id: ${repository.id}"
        holder.authorTextView.text = "Id: ${repository.nodeId}"
//        holder.titleTextView.maxLines = 2
//        holder.authorTextView.text = event.author ?: "System"
//        holder.dateTextView.text = event.date!!.toString("dd/MM/yyyy")
//        holder.contentTextView.text = event.content
//        holder.contentTextView.maxLines = 4
    }


}