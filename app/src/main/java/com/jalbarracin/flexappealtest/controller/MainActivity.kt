package com.jalbarracin.flexappealtest.controller

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.controller.adapter.RepositoryAdapter
import com.jalbarracin.flexappealtest.model.Repository
import com.jalbarracin.flexappealtest.service.GithubRetrofit
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_header.*

class MainActivity : AppCompatActivity() {

    lateinit var compositeDisposable: CompositeDisposable
    lateinit var repositoryAdapter: RepositoryAdapter
    var list: ArrayList<Repository> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sideMenuButton.setOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
        }
        filterButton.setOnClickListener {
            Toast.makeText(this, "Hello filter", Toast.LENGTH_SHORT).show()
        }

        compositeDisposable = CompositeDisposable()
        repositoryAdapter = RepositoryAdapter(this, list)
        listView.adapter = repositoryAdapter
        GithubRetrofit.getRepositories(this, repositoryAdapter, list, compositeDisposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}