package com.example.gumtreetechtest.utils

import androidx.compose.ui.text.toLowerCase
import com.example.gumtreetechtest.ui.models.Make
import com.example.gumtreetechtest.ui.models.Model
import java.util.*
val allCars:List<Model> = listOf(
    Model.Focus,
    Model.Ka,
    Model.Clio,
    Model.Captur,
    Model.Juke
)

val fordCars:List<Model> = listOf(
    Model.Focus,
    Model.Ka,
    Model.Fiesta,
    Model.Galaxy,
    Model.Kuga,
)

val renaultCars:List<Model> = listOf(
    Model.Clio,
    Model.Captur,
    Model.Twingo,
    Model.Megane
)

val nissanCars:List<Model> = listOf(
    Model.Juke
)

val mockAvailableCars = hashMapOf(
    Make.Ford.toString() to  fordCars,
    Make.Renault.toString() to renaultCars,
    Make.Nissan.toString() to allCars,
)

