package me.htookyaw.prototype.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import me.htookyaw.prototype.databinding.FragmentDetailBinding
import me.htookyaw.prototype.ui.base.BaseFragment
import me.htookyaw.prototype.ui.utils.PageIndicatorDecoration

class DetailFragment : BaseFragment<FragmentDetailBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    private val sliderAdapter = SliderAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener {
            view.findNavController().navigateUp()
        }

        with(binding.rvSlider) {
            PagerSnapHelper().attachToRecyclerView(this)
            adapter = sliderAdapter
            addItemDecoration(PageIndicatorDecoration())
        }
    }
}