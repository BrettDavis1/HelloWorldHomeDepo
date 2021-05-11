package com.example.helloworld.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.databinding.ItemPhotoBinding
import com.example.helloworld.model.Photo
import com.example.helloworld.util.loadImage

class PhotoAdapter(
    private val photos: List<Photo>
) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.loadPhoto(photos[position])
    }

    override fun getItemCount() = photos.size


    class PhotoViewHolder(
        private val binding: ItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun loadPhoto(photo: Photo) = with(binding) {
            tvTitle.text = photo.title
            ivPhoto.loadImage(photo.url)
        }
    }
}