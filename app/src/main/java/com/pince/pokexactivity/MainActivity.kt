package com.pince.pokexactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.viewpager.widget.ViewPager
import com.pince.pokexactivity.base.BindingActivity
import com.pince.pokexactivity.bean.Student
import com.pince.pokexactivity.databinding.ActivityMainBinding
import com.pince.pokexactivity.fragments.MainPagerAdapter
import com.pince.pokexactivity.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()

     /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        with(binding.mainViewpager) {
            adapter = MainPagerAdapter(supportFragmentManager)
            offscreenPageLimit = 3
            addOnPageChangeListener(
                object : ViewPager.OnPageChangeListener {
                    override fun onPageScrollStateChanged(state: Int) = Unit
                    override fun onPageScrolled(
                        position: Int,
                        positionOffset: Float,
                        positionOffsetPixels: Int
                    ) = Unit

                    override fun onPageSelected(position: Int) {
                        binding.mainBottomNavigation.menu.getItem(position).isChecked = true
                    }
                }
            )
        }
        binding.mainBottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_one -> binding.mainViewpager.currentItem = 0
                R.id.action_two -> binding.mainViewpager.currentItem = 1
                R.id.action_three -> binding.mainViewpager.currentItem = 2
            }
            true
        }
    }


}