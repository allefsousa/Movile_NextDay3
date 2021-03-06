package com.example.allef.next.movilenextday3.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso


class BindingAdapters{
    companion object { // metodo statico
        @JvmStatic @BindingAdapter("image")
        fun loadImage(imageView: ImageView, imageUrl: String?){
            Picasso.get().load(imageUrl).into(imageView)
        }
    }

}
