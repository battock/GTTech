package com.example.gumtreetechtest.domain

data class SearchResults(
    val id:String,
    val name:String,
    val title:String,
    val make:String,
    val model:String,
    val year:String,
    val price:String
)

data class ApiResults(
    val searchResults: List<SearchResults>?
)
