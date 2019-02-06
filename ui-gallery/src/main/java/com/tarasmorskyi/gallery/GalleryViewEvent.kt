package com.tarasmorskyi.gallery

import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.uicore.BaseViewEvent

sealed class GalleryViewEvent : BaseViewEvent {

    data class ShowLikeDialog(val post: Post) : GalleryViewEvent()
}