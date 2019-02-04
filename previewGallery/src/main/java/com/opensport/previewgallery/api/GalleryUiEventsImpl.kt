package com.opensport.previewgallery.api

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tarasmorskyi.gallery.api.GalleryUiEvents
import javax.inject.Inject

class GalleryUiEventsImpl @Inject constructor() : GalleryUiEvents {
    override fun showLikeDialog(activity: AppCompatActivity, likeEvent: (Unit) -> Unit) {
        Toast.makeText(activity, "PreviewActivity", Toast.LENGTH_SHORT).show()
    }
}