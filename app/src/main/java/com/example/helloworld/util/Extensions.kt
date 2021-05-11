package com.example.helloworld.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.helloworld.R

fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}