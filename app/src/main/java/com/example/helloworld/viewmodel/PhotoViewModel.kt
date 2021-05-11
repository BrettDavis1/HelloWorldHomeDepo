package com.example.helloworld.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.helloworld.repo.PhotoRepo

class PhotoViewModel: ViewModel() {

    val photosDataState = PhotoRepo.photos.asLiveData()
}