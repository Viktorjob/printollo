package com.app.printollo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.printollo.consts.GlobalStrings
import com.app.printollo.databinding.FragmentSecondBinding
import com.app.printollo.models.UserModel

class InfoFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textviewSecond.text=arguments?.
        getParcelable<UserModel>(GlobalStrings().userString).toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}