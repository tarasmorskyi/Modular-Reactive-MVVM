package com.tarasmorskyi.main.api

import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxrelay2.Relay
import com.tarasmorskyi.gallery.api.GalleryUiEvents
import com.tarasmorskyi.main.LikeDialog
import javax.inject.Inject

class GalleryUiEventsImpl @Inject constructor(
    private val mainUiEvents: MainUiEvents
) : GalleryUiEvents {

    override fun showLikeDialog(
        activity: AppCompatActivity,
        likeEvent: (Unit) -> Unit
    ) {
        val likeFragment = LikeDialog()
        likeFragment.setCallBack(likeEvent)
        likeFragment.show(activity.supportFragmentManager, "likeDialog")
    }

    override val updateNotifier: Relay<Boolean> = mainUiEvents.updateNotifier
}