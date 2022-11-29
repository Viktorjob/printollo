package com.app.printollo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.app.printollo.api.ApiHelper
import com.app.printollo.api.StorageHelper
import com.app.printollo.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.buttonFirst.isEnabled = false
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginField.addTextChangedListener {
            if(binding.loginField.text.length>5 && binding.passwordField.text.length>5 ){
                binding.buttonFirst.isEnabled = true
            }
        }
        binding.passwordField.addTextChangedListener {
            if(binding.loginField.text.length>5 && binding.passwordField.text.length>5 ){
                binding.buttonFirst.isEnabled = true
            }
        }

        binding.buttonFirst.setOnClickListener {
            StorageHelper().login(binding.loginField.text.toString(),
                binding.passwordField.text.toString())
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}