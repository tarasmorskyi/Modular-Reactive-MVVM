package com.tarasmorskyi.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_like.*

class LikeDialog : DialogFragment() {

    private var callback: (Unit) -> Unit = {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(activity as Context, R.layout.dialog_like, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        close.setOnClickListener { dismiss() }
        like.setOnClickListener {
            callback(Unit)
            dismiss()
        }
    }

    fun setCallBack(callback: (Unit) -> Unit) {
        this.callback = callback
    }
}