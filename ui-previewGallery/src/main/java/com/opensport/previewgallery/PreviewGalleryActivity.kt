package com.opensport.previewgallery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.tarasmorskyi.gallery.GalleryFragment
import com.tarasmorskyi.uicore.BaseActivity
import kotlinx.android.synthetic.main.activity_previewgallery.*

class PreviewGalleryActivity : BaseActivity<PreviewGalleryViewEvent, PreviewGalleryViewModel>() {

    private var doubleBackToExitPressedOnce: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(PreviewGalleryViewModel::class.java)

        setContentView(R.layout.activity_previewgallery)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        container.measureAllChildren

        if (savedInstanceState == null) {
            injectFragment()
        }
    }

    override fun onEvent(useCase: PreviewGalleryViewEvent) {
        TODO("not implemented")
    }

    private fun injectFragment() {

        val fragment = GalleryFragment.newInstance()
        val ts = supportFragmentManager.beginTransaction()
        ts.replace(R.id.container, fragment)
        ts.commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, R.string.exit_app, Toast.LENGTH_SHORT).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    companion object {

        fun createIntent(context: Context): Intent {
            return Intent(context, PreviewGalleryActivity::class.java)
        }
    }
}