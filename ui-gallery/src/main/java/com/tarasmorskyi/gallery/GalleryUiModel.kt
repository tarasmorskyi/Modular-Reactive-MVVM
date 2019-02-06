package com.tarasmorskyi.gallery

import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.uicore.BaseUiModel

sealed class GalleryUiModel : BaseUiModel {

    data class SetPosts(val posts: List<Post>) : GalleryUiModel()

    object ShowLoading : GalleryUiModel()

    data class ShowLikeDialog(val post: Post) : GalleryUiModel()
}