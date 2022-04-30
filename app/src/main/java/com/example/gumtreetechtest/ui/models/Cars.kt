package com.example.gumtreetechtest.ui.models

import androidx.compose.ui.graphics.vector.ImageVector

data class Car(
    val make:String = "Generic car",
    val model:String = "Version 1.0",
    val name:String = "Generic car v1",
    val title:String,
    val year:String,
    val price:String,
    val image:ImageVector
)