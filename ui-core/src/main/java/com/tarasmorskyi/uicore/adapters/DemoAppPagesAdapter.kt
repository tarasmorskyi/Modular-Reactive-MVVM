package com.tarasmorskyi.uicore.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tarasmorskyi.dataModel.Post
import com.tarasmorskyi.uicore.R
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.annotations.NonNull
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.post_item.view.*
import javax.inject.Inject


class PostsAdapter @Inject constructor() : RecyclerView.Adapter<PostsAdapter.ContactViewHolder>() {


    private val onClick = PublishSubject.create<Post>()
    private var posts: List<Post>

    val clicks: Flowable<Post>
        get() = onClick.toFlowable(BackpressureStrategy.LATEST)

    init {
        posts = emptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.post_item, parent,
            false
        )
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.setPost(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setItems(@NonNull posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    inner class ContactViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var post: Post

        fun setPost(post: Post) {
            this.post = post
            view.title.text = post.title

            Picasso.get()
                .load(post.images[0].link)
                .noFade()
                .noPlaceholder()
                .into(view.photo)

            view.photo.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            when (view.id) {
                R.id.photo -> onClick.onNext(post)
            }
        }
    }
}