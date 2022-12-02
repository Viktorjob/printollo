package com.app.printollo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.app.printollo.api.StorageHelper
import com.app.printollo.consts.GlobalStrings
import com.app.printollo.databinding.FragmentFirstBinding
import com.app.printollo.models.UserModel
import com.app.printollo.utils.ResultListener
class LoginFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

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
            loginFun(view.context)
        }
    }
    private fun loginFun(context: Context){
        StorageHelper().login(binding.loginField.text.toString(),
            binding.passwordField.text.toString(), context)
        StorageHelper().getUser(context, object : ResultListener<ArrayList<UserModel>> {
            override fun onSuccess(successModel: ArrayList<UserModel>) {
                println("ora 123")
                val bundle = bundleOf(GlobalStrings().userString to successModel[0])
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            }
            override fun onFail(any: String?) {
                println("ora 231"+any.toString())

                //handle Fail result
            }
            override fun onError(e: Throwable?) {
                println("ora 321"+e.toString())

                //handle Error
            }
        })

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}