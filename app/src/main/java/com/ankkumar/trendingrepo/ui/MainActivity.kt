package com.ankkumar.trendingrepo.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankkumar.trendingrepo.R
import com.ankkumar.trendingrepo.model.RepoEntity
import com.ankkumar.trendingrepo.utils.CheckNetwork
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainViewModel: MainViewModel

    private lateinit var adapter: RepoAdapter
    private var list: ArrayList<RepoEntity> = arrayListOf()
    private lateinit var mLinearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialiseViewModel()
        observeHomeViewModel()
        initialiseRecyclerView()
    }

    private fun initialiseViewModel() {
        mainViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private fun observeHomeViewModel() {
        if (CheckNetwork.isNetworkConnected(this)) {
            mainViewModel.getRepos()
            mainViewModel.getReposObserver().observe(this, Observer {
                if (it != null) {
                    if (it.isNotEmpty())
                        defaultText.visibility = View.GONE
                    adapter.addList(it)
                    mainViewModel.saveReposToDB(it)
                }
            })
        } else {
            mainViewModel.getReposFromDB().observe(this, Observer {
                if (it != null) {
                    if (it.isNotEmpty())
                        defaultText.visibility = View.GONE
                    adapter.addList(it)
                }
            })
        }
    }

    private fun initialiseRecyclerView() {
        adapter = RepoAdapter(this, list)
        mLinearLayoutManager = LinearLayoutManager(this)
        recyclerViewLocal.layoutManager = mLinearLayoutManager
        recyclerViewLocal.adapter = adapter

    }

}