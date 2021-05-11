package com.example.helloworld.repo

import com.example.helloworld.repo.remote.RetrofitInstance
import com.example.helloworld.util.DataState
import kotlinx.coroutines.flow.flow

object PhotoRepo {

    val photos = flow {
        emit(DataState.Loading)
        val dataState = try {
            val photoList = RetrofitInstance.service.getPhotos()
            if (photoList.isNotEmpty()) DataState.Success(photoList)
            else DataState.Error("No Photos found")
        } catch (ex: Exception) {
            DataState.Error("Something went wrong.")
        }
        emit(dataState)
    }
}