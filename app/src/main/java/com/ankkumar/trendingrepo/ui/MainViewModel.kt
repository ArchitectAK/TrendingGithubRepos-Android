package com.ankkumar.trendingrepo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankkumar.trendingrepo.model.RepoEntity
import com.ankkumar.trendingrepo.retrofit.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val postsData = MutableLiveData<List<RepoEntity>>()
    fun getRepos() {
        repository.getRepos().enqueue(object : Callback<List<RepoEntity>> {
            override fun onFailure(call: Call<List<RepoEntity>>, t: Throwable) {
                postsData.value = null
            }

            override fun onResponse(
                call: Call<List<RepoEntity>>,
                response: Response<List<RepoEntity>>
            ) {
                if (response.isSuccessful) {
                    postsData.value = response.body()
                }
            }
        })
    }

    fun getReposObserver(): LiveData<List<RepoEntity>> = postsData


    fun saveReposToDB(entityList: List<RepoEntity>) {
        repository.saveReposInDB(entityList)
    }

    fun getReposFromDB(): LiveData<List<RepoEntity>> {
        return repository.getReposFromLocalDB()
    }

}