package com.ankkumar.trendingrepo.model

import androidx.room.Entity


@Entity(tableName = "RepoTable")
data class RepoModel(
    val author: String,
    val name: String,
    val avatar: String,
    val description: String,
    val language: String,
    val languageColor: String,
    val stars: String,
    val forks: String
)