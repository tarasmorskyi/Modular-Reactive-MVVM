package com.opensport.gallery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tarasmorskyi.uicore.BaseFragment
import com.tarasmorskyi.uicore.adapters.PostsAdapter
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_gallery.*
import javax.inject.Inject

class GalleryFragment : BaseFragment<GalleryViewEvent, GalleryViewModel>() {

    @Inject
    lateinit var adapter: PostsAdapter

    private lateinit var clicksStream: Disposable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(activity as Context, R.layout.fragment_gallery, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        list.adapter = adapter
        clicksStream = adapter.clicks
            .map { GalleryViewModelEvent.PostClicked(it) }
            .toObservable().subscribe { viewModel.event(it) }
        viewModel.postsObservable.observe(this, Observer {
            adapter.setItems(it)
        })

        viewModel.event(GalleryViewModelEvent.GetPosts)
    }

    override fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(GalleryViewModel::class.java)
    }

    override fun onEvent(useCasae: GalleryViewEvent) {
        TODO("manage events from VM here. Never do request back to VM from here.")
    }

    companion object {
        fun newInstance(): GalleryFragment {
            return GalleryFragment()
        }
    }
}