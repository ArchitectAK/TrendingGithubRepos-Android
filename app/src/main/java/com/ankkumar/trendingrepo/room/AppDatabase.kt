package com.ankkumar.trendingrepo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ankkumar.trendingrepo.model.RepoEntity

@Database(entities = [RepoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDAO(): RepoDAO
}