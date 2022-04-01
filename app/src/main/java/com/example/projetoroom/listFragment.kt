package com.example.projetoroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoroom.adapter.UserAdapter
import com.example.projetoroom.databinding.FragmentListBinding

class listFragment : Fragment() {

    private lateinit var mainViewModel: mainViewModel
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(
            layoutInflater, container, false
        )

        val adapter = UserAdapter()

        mainViewModel = mainViewModel(context)
        mainViewModel.lerTodosOsDados.observe(viewLifecycleOwner){
            adapter.setList(it)
        }

        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        binding.recyclerUser.adapter = adapter
        binding.recyclerUser.setHasFixedSize(true)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root
    }


}