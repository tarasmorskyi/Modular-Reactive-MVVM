package com.tarasmorskyi.uicore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tarasmorskyi.data_model.Post
import com.tarasmorskyi.uicore.R
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.annotations.NonNull
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.post_item.view.*
import javax.inject.Inject


class PostsAdapter @Inject constructor(
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<PostsAdapter.ContactViewHolder>() {

    private val onClick = PublishSubject.create<Post>()
    private var pages: List<Post>

    val clicks: Flowable<Post>
        get() = onClick.toFlowable(BackpressureStrategy.LATEST)

    init {
        pages = emptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent,
            false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.setPost(pages!![position])
    }

    override fun getItemCount(): Int {
        return pages!!.size
    }

    fun setItems(@NonNull pages: List<Post>) {
        this.pages = pages
        notifyDataSetChanged()
    }

    inner class ContactViewHolder(
        private val view : View) : RecyclerView.ViewHolder(
        view), View.OnClickListener {
        lateinit private var page: Post

        fun setPost(page: Post) {
            this.page = page
            view.title.text = page.title

            if(page.images.size > 0) {
                Glide
                    .with(view.photo.context)
                    .load(page.images[0].link)
                    .into(view.photo)
            }else
                Glide
                    .with(view.photo.context)
                    .load(page.link)
                    .into(view.photo)


            view.photo.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            when (view.id) {
                R.id.photo -> onClick.onNext(page)
            }
        }
    }
}