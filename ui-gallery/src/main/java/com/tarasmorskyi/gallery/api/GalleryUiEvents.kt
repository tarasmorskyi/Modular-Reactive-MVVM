package com.tarasmorskyi.gallery.api

import androidx.appcompat.app.AppCompatActivity

interface GalleryUiEvents {
    fun showLikeDialog(activity: AppCompatActivity, likeEvent : (Unit) -> Unit)
}