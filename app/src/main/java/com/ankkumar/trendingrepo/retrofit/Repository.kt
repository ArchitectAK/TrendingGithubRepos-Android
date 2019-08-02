package com.ankkumar.trendingrepo.retrofit

import androidx.lifecycle.LiveData
import com.ankkumar.trendingrepo.model.RepoEntity
import com.ankkumar.trendingrepo.room.AppDatabase
import retrofit2.Call

class Repository constructor(
    private val apiService: APIService,
    private val database: AppDatabase
) {
    fun getRepos(): Call<List<RepoEntity>> {
        return apiService.getTrendingRepos()
    }

    fun saveReposInDB(entityList: List<RepoEntity>) {
        val thread = Thread(Runnable { database.postDAO().saveRepos(entityList) })
        thread.start()
    }

    fun getReposFromLocalDB(): LiveData<List<RepoEntity>> {
        return database.postDAO().getRepos()
    }

}