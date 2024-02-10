package com.gabrielcastro.practicaandroidsuperpoderes.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperHeroDetail(
    val id: Long,
    val name: String,
    val photo: String,
    val description: String,
    var favorite: Boolean
) : Parcelable

@Parcelize
data class SeriesPresent(
    val id: Long,
    val title: String,
    val description: String?,
    val photo: String
) : Parcelable

@Parcelize
data class ComicsPresent(
    val id: Long,
    val title: String,
    val description: String?,
    val photo: String
) : Parcelable