package com.opensport.gallery

import com.tarasmorskyi.data_model.Post
import com.tarasmorskyi.uicore.BaseViewModelEvent

sealed class GalleryViewModelEvent : BaseViewModelEvent {
    object GetPosts : GalleryViewModelEvent()

    data class PostClicked(val post: Post) : GalleryViewModelEvent()
}