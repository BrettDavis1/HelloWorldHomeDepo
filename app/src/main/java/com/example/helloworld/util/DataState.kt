package com.example.helloworld.util

sealed class DataState<out R> {
    data class Success<T>(val data: T) : DataState<T>()
    data class Error(val errorMsg: String) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
