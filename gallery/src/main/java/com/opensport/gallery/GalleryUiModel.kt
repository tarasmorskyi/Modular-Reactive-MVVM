package com.opensport.gallery

import com.tarasmorskyi.data_model.Post
import com.tarasmorskyi.uicore.BaseUiModel

sealed class GalleryUiModel : BaseUiModel {
    data class SetPosts(val pages: List<Post>) : GalleryUiModel()
    object ShowLoading : GalleryUiModel()
}