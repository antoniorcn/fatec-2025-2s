package edu.curso.agendacontato

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.text.iterator

class ContatoViewModel : ViewModel() {
    val httpClient = createHttpClient()
    val contatoApi = ContatoApi( httpClient )

    val nome : MutableState<String> = mutableStateOf("")
    val telefone : MutableState<String> = mutableStateOf("")
    val email : MutableState<String> = mutableStateOf("")

    val lista : MutableState<List<Contato>> = mutableStateOf( listOf())

    val snackbarHostState = mutableStateOf(SnackbarHostState() )

    fun adicionar() {
        val contato = Contato(nome = nome.value,
            telefone = telefone.value,
            email = email.value)
        val listaNova : MutableList<Contato> = mutableListOf()
        listaNova.addAll( lista.value )
        listaNova.add( contato )
        lista.value = listaNova

        viewModelScope.launch {
            contatoApi.adicionar(contato)
            snackbarHostState.value.showSnackbar("Contato cadastrado com sucesso")

        }
    }

    fun pesquisar() {
        viewModelScope.launch {
            lista.value = contatoApi.getAll()
        }
        for (contato in lista.value) {
            if (contato.nome.contains( nome.value )) {
                nome.value = contato.nome
                telefone.value = contato.telefone
                email.value = contato.email
            }
        }
    }
}