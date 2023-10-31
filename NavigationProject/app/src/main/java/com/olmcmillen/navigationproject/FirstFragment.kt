package com.olmcmillen.navigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.olmcmillen.navigationproject.databinding.FragmentFirstBinding



class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //If display image 1 button is clicked
        binding.button1.setOnClickListener {
            val action: FirstFragmentDirections.MainToSecond  =
                FirstFragmentDirections.mainToSecond()
            action.argsHeaderText = "Image 1"
            action.argsImageReference = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action)
        }

        //If display image 2 button is clicked
        binding.button2.setOnClickListener {
            val action: FirstFragmentDirections.MainToSecond  =
                FirstFragmentDirections.mainToSecond()
            action.argsHeaderText = "Image 2"
            action.argsImageReference = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action)
        }

        //If display image 3 button is clicked
        binding.button3.setOnClickListener {
            val action: FirstFragmentDirections.MainToSecond  =
                FirstFragmentDirections.mainToSecond()
            action.argsHeaderText = "Image 3"
            action.argsImageReference = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}