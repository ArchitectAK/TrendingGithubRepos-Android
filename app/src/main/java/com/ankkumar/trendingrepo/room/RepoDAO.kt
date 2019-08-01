package com.ankkumar.trendingrepo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ankkumar.trendingrepo.model.RepoEntity

@Dao
interface RepoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun saveRepos(entityList: List<RepoEntity>)

    @Query("SELECT * FROM RepoTable")
    fun getRepos(): LiveData<List<RepoEntity>>


}