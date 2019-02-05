package com.tarasmorskyi.gallery

import androidx.lifecycle.MutableLiveData
import com.jakewharton.rxrelay2.PublishRelay
import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.gallery.interactors.GalleryInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject

class GalleryViewModel @Inject
constructor(
    private val interactor: GalleryInteractor
) : BaseViewModel<GalleryUiModel, GalleryViewModelEvent, GalleryViewEvent>() {

    var loadingObservable: MutableLiveData<Boolean> = MutableLiveData()
    var postsObservable: MutableLiveData<List<Post>> = MutableLiveData()


    override fun onEvent(useCase: GalleryViewModelEvent): ObservableSource<out GalleryUiModel> {
        return when (useCase) {
            is GalleryViewModelEvent.GetPosts -> interactor.posts.map { GalleryUiModel.SetPosts(it) as GalleryUiModel }
                .toObservable()
                .startWith(GalleryUiModel.ShowLoading)
            is GalleryViewModelEvent.PostClicked -> Observable.just(GalleryUiModel.ShowLikeDialog(useCase.post))
            is GalleryViewModelEvent.Like -> interactor.like(useCase.post).andThen(Observable.empty())
        }
    }

    override fun onNext(useCase: GalleryUiModel) = when (useCase)
    {
        is GalleryUiModel.SetPosts -> {
            loadingObservable.value = false
            postsObservable.value = useCase.posts
        }
        is GalleryUiModel.ShowLoading -> loadingObservable.value = true
        is GalleryUiModel.ShowLikeDialog -> viewEventObservable.value = GalleryViewEvent.ShowLikeDialog(useCase.post)
    }
}