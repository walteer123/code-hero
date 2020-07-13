package com.example.code_hero.data.entity

data class RemoteData<T> (
    val offset : Int, val limit : Int, val total : Int,
    val count : Int,
    val results : List<T>
)