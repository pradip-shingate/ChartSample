package com.sample.chartsample.views.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sample.chartsample.databinding.FragmentNotificationsBinding
import com.sample.chartsample.databinding.UserFragmentBinding
import com.sample.chartsample.views.ui.notifications.NotificationsViewModel

class UserFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel
    private var _binding: UserFragmentBinding?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = UserFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textUser
        userViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}