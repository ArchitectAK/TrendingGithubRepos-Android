package com.ankkumar.trendingrepo.retrofit

import com.ankkumar.trendingrepo.model.RepoEntity
import com.ankkumar.trendingrepo.utils.Utils.ENDPOINT_REPO
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET(value = ENDPOINT_REPO)
    fun getTrendingRepos(): Call<List<RepoEntity>>
}