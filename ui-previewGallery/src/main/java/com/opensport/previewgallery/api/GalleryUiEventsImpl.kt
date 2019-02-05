package com.opensport.previewgallery.api

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import com.tarasmorskyi.gallery.api.GalleryUiEvents
import javax.inject.Inject

class GalleryUiEventsImpl @Inject constructor() : GalleryUiEvents {

    override fun showLikeDialog(activity: AppCompatActivity, likeEvent: (Unit) -> Unit) {
        Toast.makeText(activity, "PreviewActivity", Toast.LENGTH_SHORT).show()
    }

    override val updateNotifier: Relay<Boolean>
        get() = PublishRelay.create()
}