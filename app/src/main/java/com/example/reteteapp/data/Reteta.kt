package com.example.reteteapp.data


import androidx.annotation.DrawableRes

data class Reteta(
    val nume: String,
    val descriere: String,
    @DrawableRes val imagineResursa: Int
)