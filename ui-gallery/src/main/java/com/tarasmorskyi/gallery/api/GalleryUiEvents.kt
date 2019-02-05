package com.tarasmorskyi.gallery.api

import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxrelay2.Relay

interface GalleryUiEvents {
    fun showLikeDialog(activity: AppCompatActivity, likeEvent : (Unit) -> Unit)

    val updateNotifier: Relay<Boolean>
}