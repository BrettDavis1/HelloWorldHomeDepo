package com.example.helloworld.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.helloworld.adapter.PhotoAdapter
import com.example.helloworld.databinding.ActivityMainBinding
import com.example.helloworld.util.DataState
import com.example.helloworld.viewmodel.PhotoViewModel

/*
Consume the api below and list the items in a recycler view.
Recycler view cell should have a image thumbnail to the left and title to the right
API End Point https://jsonplaceholder.typicode.com/photos
 Feel free to use any third party libraries like retrofit or Picasso or glid
 */
class MainActivity : AppCompatActivity() {

    private val photoViewModel by viewModels<PhotoViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        photoViewModel.photosDataState.observe(this) { state ->
            binding.progressBar.isVisible = state is DataState.Loading
            if (state is DataState.Success) {
                binding.rvPhotos.adapter = PhotoAdapter(state.data)
            }
        }
    }
}