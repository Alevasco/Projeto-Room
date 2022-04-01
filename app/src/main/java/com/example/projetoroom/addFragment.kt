package com.example.projetoroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projetoroom.databinding.FragmentAddBinding
import com.example.projetoroom.model.User


class addFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mainViewModel: mainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(
            layoutInflater, container, false
        )

        mainViewModel = mainViewModel(context)

        binding.buttonCadastrar.setOnClickListener{
            inserirNoBanco()
        }

        return binding.root
    }

    fun validar (nome: String, sobrenome: String, idade: String): Boolean{
        return !(nome.isEmpty() || sobrenome.isEmpty() || idade.isEmpty())
    }

    fun inserirNoBanco(){

        val nome = binding.editNome.text.toString()
        val sobrenome = binding.editSobrenome.text.toString()
        val idade = binding.editIdade.text.toString()

        if (validar(nome, sobrenome, idade)){
            val user = User(0, nome, sobrenome, idade.toInt())
            mainViewModel.addUser(user)
            Toast.makeText(
                context, "Usuário Cadastrado", Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(
                context,"Preencha todos os campos!", Toast.LENGTH_LONG
            ).show()
        }
    }

}