package com.sample.chartsample.views.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sample.chartsample.databinding.FragmentNotificationsBinding
import com.sample.chartsample.databinding.SearchFragmentBinding
import com.sample.chartsample.databinding.UserFragmentBinding
import com.sample.chartsample.views.ui.notifications.NotificationsViewModel
import com.sample.chartsample.views.ui.user.UserViewModel

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private var _binding: SearchFragmentBinding?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSearch
        searchViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}