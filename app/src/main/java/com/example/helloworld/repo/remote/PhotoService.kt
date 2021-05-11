package com.example.helloworld.repo.remote

import com.example.helloworld.model.Photo
import retrofit2.http.GET

interface PhotoService {

    @GET("/photos")
    suspend fun getPhotos() : List<Photo>
}