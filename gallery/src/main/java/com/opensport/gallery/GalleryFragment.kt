package com.opensport.gallery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.tarasmorskyi.uicore.BaseFragment

class GalleryFragment : BaseFragment<GalleryViewEvent, GalleryViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(activity as Context, R.layout.fragment_gallery, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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