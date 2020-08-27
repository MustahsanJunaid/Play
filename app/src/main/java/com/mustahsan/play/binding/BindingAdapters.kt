package com.mustahsan.play.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.MediaStoreSignature

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, imageUrl: String?) {
        imageUrl?.let {
            Glide
                .with(imageView)
                .load(imageUrl)
                .signature(MediaStoreSignature("", 0, 1))
                .centerCrop()
//        .placeholder(placeholder)
                .into(imageView)
        }
    }
}