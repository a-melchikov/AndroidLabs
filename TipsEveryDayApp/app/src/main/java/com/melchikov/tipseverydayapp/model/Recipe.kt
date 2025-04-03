package com.melchikov.tipseverydayapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// для того чтобы работал метод showRecipeDetails в MainActivity передача объекта через Intent
@Parcelize
data class Recipe(
    val id: Int,
    val day: Int,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val imageResId: Int
) : Parcelable