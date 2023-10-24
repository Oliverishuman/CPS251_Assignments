package com.olmcmillen.lifecycleawareness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.olmcmillen.lifecycleawareness.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_main, container, false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.namesView.text = viewModel.getNames()

        binding.addNameButton.setOnClickListener {
            if (binding.enterName.text.isNotEmpty()){
                viewModel.setNames(binding.enterName.text.toString())
                binding.namesView.text = viewModel.getNames()
            }
            else {
                this.binding.namesView.text = getString(R.string.noNameEntered)
            }
        }
    }

}