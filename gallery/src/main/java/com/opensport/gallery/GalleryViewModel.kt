package com.opensport.gallery

import androidx.lifecycle.MutableLiveData
import com.opensport.gallery.interactors.GalleryInteractor
import com.tarasmorskyi.data_model.Post
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.ObservableSource
import javax.inject.Inject

class GalleryViewModel @Inject
constructor(private val interactor: GalleryInteractor) :
    BaseViewModel<GalleryUiModel, GalleryViewModelEvent, GalleryViewEvent>() {

    var loadingObservable: MutableLiveData<Boolean> = MutableLiveData()
    var postsObservable: MutableLiveData<List<Post>> = MutableLiveData()


    override fun onEvent(useCase: GalleryViewModelEvent): ObservableSource<out GalleryUiModel> {
        return when (useCase) {
            is GalleryViewModelEvent.GetPosts -> interactor.posts.map { GalleryUiModel.SetPosts(it) as GalleryUiModel }
                .toObservable()
                .startWith(GalleryUiModel.ShowLoading)
            is GalleryViewModelEvent.PostClicked -> TODO()
        }
    }

    override fun onNext(useCase: GalleryUiModel) = when (useCase) {
        is GalleryUiModel.SetPosts -> {
            loadingObservable.value = false
            postsObservable.value = useCase.pages
        }
        is GalleryUiModel.ShowLoading -> loadingObservable.value = true
    }
}