package com.ankkumar.trendingrepo.ui

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainViewModel: MainViewModel

    private lateinit var albumAdapter: AlbumAdapter
    private var albumList: ArrayList<AlbumEntity> = arrayListOf()
    private lateinit var mLinearLayoutManager: LinearLayoutManager
}