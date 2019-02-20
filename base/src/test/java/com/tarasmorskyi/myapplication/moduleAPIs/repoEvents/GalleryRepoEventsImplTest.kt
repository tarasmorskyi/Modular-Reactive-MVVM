package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.nhaarman.mockitokotlin2.*
import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.localstorage.LocalRepository
import com.tarasmorskyi.remote.RemoteRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GalleryRepoEventsImplTest {

    lateinit var galleryRepoEventsImpl: GalleryRepoEventsImpl

    lateinit var remote: RemoteRepository
    lateinit var local: LocalRepository

    @BeforeEach
    fun setUp() {
        remote = mock { }
        local = mock { }
        galleryRepoEventsImpl = GalleryRepoEventsImpl(local, remote)
    }

    @Test
    fun like() {
        val post = Post()
        whenever(remote.likePost(post)).thenReturn(Completable.complete())
        galleryRepoEventsImpl.like(post).test().assertComplete().assertNoErrors()
        verify(remote).likePost(post)
    }

    @Test
    fun getPosts() {
        val searchSettings = SearchSettings()
        val list: List<Post> = ArrayList()
        val postsResult = Maybe.just(list)
        whenever(local.searchSettings).thenReturn(Maybe.just(searchSettings))
        whenever(remote.getPages(searchSettings)).thenReturn(postsResult)
        galleryRepoEventsImpl.posts.test().assertNoErrors().assertValue(list)
        verify(local).searchSettings
        verify(remote).getPages(searchSettings)
    }

    @Test
    fun getPostsSearchSettingsEmpty() {
        val searchSettings = SearchSettings()
        val list: List<Post> = ArrayList()
        val postsResult = Maybe.just(list)
        whenever(local.searchSettings).thenReturn(Maybe.empty())
        whenever(remote.getPages(searchSettings)).thenReturn(postsResult)
        galleryRepoEventsImpl.posts.test().assertNoValues()
        verify(local).searchSettings
        verify(remote, never()).getPages(any())
    }

    @Test
    fun getPostsPostsEmpty() {
        val searchSettings = SearchSettings()
        val postsResult = Maybe.empty<List<Post>>()
        whenever(local.searchSettings).thenReturn(Maybe.just(searchSettings))
        whenever(remote.getPages(searchSettings)).thenReturn(postsResult)
        galleryRepoEventsImpl.posts.test().assertNoValues()
        verify(local).searchSettings
        verify(remote).getPages(searchSettings)
    }
}