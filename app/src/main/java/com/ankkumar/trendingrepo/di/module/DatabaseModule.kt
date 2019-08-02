package com.ankkumar.trendingrepo.di.module

import android.content.Context
import androidx.room.Room
import com.ankkumar.trendingrepo.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    private var INSTANCE: AppDatabase? = null

    @Provides
    @Singleton
    fun getDatabase(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(context, AppDatabase::class.java, "repos_db").build()

                }
            }
        }
        return INSTANCE!!
    }


}