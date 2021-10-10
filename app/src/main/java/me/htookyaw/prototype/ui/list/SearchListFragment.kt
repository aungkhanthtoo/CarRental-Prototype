package me.htookyaw.prototype.ui.list

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import me.htookyaw.prototype.R
import me.htookyaw.prototype.databinding.FragmentListBinding
import me.htookyaw.prototype.ui.base.BaseFragment

class SearchListFragment : BaseFragment<FragmentListBinding>() {

    private val listAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> = getDummyAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchControl.btnSearch.isVisible = false
        binding.toolbar.setNavigationOnClickListener {
            view.findNavController().navigateUp()
        }

        with(binding.rvSearchResults) {
            setHasFixedSize(true)
            addItemDecoration(
                dividerDecoration()
            )
            adapter = listAdapter
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }


    private fun dividerDecoration() =
        DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL
        ).apply {
            setDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.divider_color
                    )
                )
            )
        }


    private fun getDummyAdapter() = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): RecyclerView.ViewHolder = object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_car_list, parent, false)
        ) {
            init {
                itemView.setOnClickListener {
                    findNavController().navigate(R.id.action_navigation_list_to_navigation_detail)
                }
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        }

        override fun getItemCount(): Int {
            return 5
        }
    }

}