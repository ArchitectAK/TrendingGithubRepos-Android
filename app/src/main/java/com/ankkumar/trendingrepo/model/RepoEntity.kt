package com.ankkumar.trendingrepo.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "RepoTable")
data class RepoEntity(
    val author: String,
    val name: String,
    val avatar: String,
    @PrimaryKey
    val url: String,
    val description: String,
    val language: String,
    val languageColor: String,
    val stars: String,
    val forks: String
)