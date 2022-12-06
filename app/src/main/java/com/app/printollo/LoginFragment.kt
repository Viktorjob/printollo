package com.app.printollo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
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
        val progress = Progress(_binding!!.progressBarHolder)
        progress.onPreExecute()
        disableElement()
        StorageHelper().login(binding.loginField.text.toString(),
            binding.passwordField.text.toString(), context,  object : ResultListener<String> {
                override fun onSuccess(successModel: String) {
                    println("ora 123")
                    getUser(context)
                }
                override fun onFail(any: String?) {
                    println("ora 231"+any.toString())
                    progress.onPostExecute()
                    enableElement()
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
                override fun onError(e: Throwable?) {
                    println("ora 321"+e.toString())
                    progress.onPostExecute()
                    enableElement()
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            })
    }
     fun getUser(context: Context){
         val progress = Progress(_binding!!.progressBarHolder)
         println("ora 343434")
         StorageHelper().getUser(context, object : ResultListener<ArrayList<UserModel>> {
             override fun onSuccess(successModel: ArrayList<UserModel>) {
                 println("ora 123")
                 progress.onPostExecute()
                 enableElement()
                 val bundle = bundleOf(GlobalStrings().userString to successModel[0])
                 findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
             }
             override fun onFail(any: String?) {
                 println("ora 231"+any.toString())
                 progress.onPostExecute()
                 enableElement()
                 //handle Fail result
             }
             override fun onError(e: Throwable?) {
                 println("ora 321"+e.toString())
                 enableElement()
                 progress.onPostExecute()
             }
         })
     }
    fun disableElement(){
        val layout = binding.root
        for (i in 0 until layout.childCount) {
            val child = layout.getChildAt(i)
            child.isEnabled = false
            child.isClickable = false
        }
    }
    fun enableElement(){
        val layout = binding.root
        for (i in 0 until layout.childCount) {
            val child = layout.getChildAt(i)
            child.isEnabled = true
            child.isClickable = true
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}