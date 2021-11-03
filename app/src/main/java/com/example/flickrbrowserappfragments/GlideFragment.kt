package com.example.flickrbrowserappfragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide


class GlideFragment : Fragment() {
    lateinit var imageView: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_glide, container, false)
        imageView = view.findViewById(R.id.imageView)
        val sharedPreferences = requireActivity().getSharedPreferences("sp", Context.MODE_PRIVATE)
        // retrieve from sharedPreferences
        val link = sharedPreferences.getString("link", "")
        openImage(link!!)
        imageView.setOnClickListener { closeImage() }
        return view
    }
    //open image glide
    fun openImage(link: String){
        Glide.with(this)
            .load(link)
            .into(imageView)
    }
    // close image
    private fun closeImage(){
//        startActivity(
//            Intent(this,MainActivity::class.java)
//        )
        //nav to main fragment
    findNavController().navigate(R.id.action_glideFragment_to_mainFragment)
    }
}