package edu.curso.agenda.viewmodel

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import edu.curso.agenda.api.ContatoApi
import edu.curso.agenda.api.createHttpClient
import edu.curso.agenda.model.Contato
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.launch

class ContatoViewModel : ViewModel() {
    val nome : MutableState<String> = mutableStateOf("")
    val email : MutableState<String> = mutableStateOf("")
    val telefone : MutableState<String> = mutableStateOf("")

    val lista : MutableState<List<Contato>> = mutableStateOf( listOf() )

    val httpClient = createHttpClient()
    val contatoApi = ContatoApi( httpClient )

    lateinit var navController : NavHostController

    val snackMessage : MutableState<SnackbarHostState> =
        mutableStateOf(SnackbarHostState() )

    fun formulario() {
        navController.navigate("FORM")
    }

    fun listagem() {
        navController.navigate("LISTA")
    }

    fun adicionar() {
        val contato = Contato( nome.value,
            email.value,
            telefone.value)
//        val listaNova : MutableList<Contato> = mutableListOf()
//        listaNova.addAll( lista.value )
//        listaNova.add( contato )
//        lista.value = listaNova
//        print("Contato $contato adicionado com sucesso")
//        print(lista.value)
        viewModelScope.launch {
            contatoApi.adicionarApi( contato )
            snackMessage.value.showSnackbar("Contato gravado com sucesso")
            lista.value = contatoApi.pesquisarApi()
        }
    }

    fun pesquisar() {
        viewModelScope.launch {
            lista.value = contatoApi.pesquisarApi()
        }
//        for (c in lista.value) {
//            if (c.nome.contains( nome.value )) {
//                nome.value = c.nome
//                email.value = c.email
//                telefone.value = c.telefone
//                break
//            }
//        }
    }
}