package com.tarasmorskyi.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.tarasmorskyi.gallery.GalleryFragment
import com.tarasmorskyi.main.settings.SettingsFragment
import com.tarasmorskyi.mygallery.MyGalleryFragment
import com.tarasmorskyi.uicore.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewEvent, MainViewModel>(), AHBottomNavigation.OnTabSelectedListener {

    internal var selectedView: Int = -1
    lateinit private var currentFragment: Fragment
    private var doubleBackToExitPressedOnce: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(MainViewModel::class.java)

        setContentView(R.layout.activity_main)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val item1 = AHBottomNavigationItem(
            R.string.gallery, R.drawable.abc_ic_star_black_16dp,
            R.color.black
        )
        val item2 = AHBottomNavigationItem(
            R.string.my_gallery, R.drawable.abc_ic_star_black_16dp,
            R.color.black
        )
        val item3 = AHBottomNavigationItem(
            R.string.settings, R.drawable.abc_ic_star_black_16dp,
            R.color.black
        )
        container.measureAllChildren
        bottom_navigation.addItem(item1)
        bottom_navigation.addItem(item2)
        bottom_navigation.addItem(item3)

        if (savedInstanceState == null) {
            viewModel.fragmentPositionObservable.value = GALLERY
        }
        viewModel.fragmentPositionObservable.value?.let {
            bottom_navigation.currentItem = it
        }
        bottom_navigation.setOnTabSelectedListener(this)
        viewModel.fragmentPositionObservable.observe(this, Observer { injectView(it) })
    }

    override fun onEvent(useCase: MainViewEvent) {
        TODO("not implemented") //
    }

    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {
        viewModel.fragmentPositionObservable.postValue(position)
        return true
    }

    private fun injectView(position: Int) {
        if (selectedView == position) {
            return
        }
        selectedView = position
        injectFragment(getFragmentTag(position))
        bottom_navigation.currentItem = position
    }

    private fun getFragmentTag(position: Int): String {
        return when (position) {
            GALLERY -> GALLERY_TAG
            MY_GALLERY -> MY_GALLERY_TAG
            SETTINGS -> SETTINGS_TAG
            else -> GALLERY_TAG
        }
    }

    private fun getPreviousView(): Int {
        val fm = supportFragmentManager
        val count = fm.backStackEntryCount
        return if (count > 0) Integer.valueOf(fm.getBackStackEntryAt(count).name?.let { it } ?: "") else -1
    }

    private fun injectFragment(tag: String) {
        if (::currentFragment.isInitialized) {
            val ts = supportFragmentManager.beginTransaction()
            ts.hide(currentFragment)
            ts.commit()
        }

        currentFragment =
                supportFragmentManager.findFragmentByTag(tag)?.let { it } ?: addFragment(tag)

        val ts = supportFragmentManager.beginTransaction()
        val newView = selectedView.toString()
        if (newView != getPreviousView().toString()) {
            ts.show(currentFragment)
            ts.commitAllowingStateLoss()
        }
    }

    private fun addFragment(tag: String): Fragment {
        val fragment: Fragment = when (tag) {
            GALLERY_TAG -> GalleryFragment.newInstance()
            MY_GALLERY_TAG -> MyGalleryFragment.newInstance()
            SETTINGS_TAG -> SettingsFragment.newInstance()
            else -> GalleryFragment.newInstance()
        }
        val ts = supportFragmentManager.beginTransaction()
        ts.add(R.id.container, fragment, tag)
        ts.commitNowAllowingStateLoss()
        return fragment
    }

    override fun onBackPressed() {
        if (selectedView == GALLERY) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
                return
            }

            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this, R.string.exit_app, Toast.LENGTH_SHORT).show()

            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
        } else {
            injectView(GALLERY)
        }
    }

    companion object {
        private const val GALLERY = 0
        private const val MY_GALLERY = 1
        private const val SETTINGS = 2
        private const val GALLERY_TAG = "gallery"
        private const val MY_GALLERY_TAG = "my_gallery"
        private const val SETTINGS_TAG = "settings"

        fun createIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            return intent
        }
    }
}