package com.example.code_hero.data.entity

data class Response<T>(
    val code : Int,
    val data: T
)