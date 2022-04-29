package com.example.gumtreetechtest.ui.models


enum class Make {
    All,
    Ford,
    Renault,
    Nissan
}

enum class Model {
    Focus,
    Ka,
    Clio,
    Captur,
    Juke,
    Fiesta,
    Galaxy,
    Kuga,
    Twingo,
    Megane
}

data class Car(
    val make:Make = Make.Ford,
    val model:Model = Model.Focus
)