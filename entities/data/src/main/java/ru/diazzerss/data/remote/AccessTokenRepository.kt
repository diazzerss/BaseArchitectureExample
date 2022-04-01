package ru.diazzerss.data.remote

interface AccessTokenRepository {
    fun refreshAccessToken(): String
    fun getAccessToken(): String
}