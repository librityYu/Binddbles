package com.pince.pokexactivity.fragments


import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pince.pokexactivity.base.BindingFragment
import com.pince.pokexactivity.R
import com.pince.pokexactivity.databinding.FragmentHomeBinding
import com.pince.pokexactivity.recycler.PosterAdapter
import com.pince.pokexactivity.vm.MainViewModel

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

  private val vm: MainViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreateView(inflater, container, savedInstanceState)
    return binding {
      viewModel = vm
      adapter = PosterAdapter()
    }.root
  }
}
