package edu.curso.agenda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.RoundedCorner
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.curso.agenda.viewmodel.ContatoViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ContatoFormulario(contatovm : ContatoViewModel ) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            //            .fillMaxHeight()
            //            .fillMaxWidth()
            .fillMaxWidth()
            .padding(10.dp, 30.dp)
            .background( color = Color.White,
                shape = RoundedCornerShape(30.dp)
            )
            .padding(15.dp, 30.dp)
    ) {
        Text("Formulario")
        TextField(
            value = contatovm.nome.value, onValueChange = { contatovm.nome.value = it },
            label = { Text("Nome completo") },
            placeholder = { Text("Informe seu nome completo") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = contatovm.email.value, onValueChange = { contatovm.email.value = it },
            label = { Text("Email") },
            placeholder = { Text("Informe um email valido") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = contatovm.telefone.value, onValueChange = { contatovm.telefone.value = it },
            label = { Text("Telefone") },
            placeholder = { Text("Informe seu DDD e telefone") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ContatoListagem(contatovm: ContatoViewModel) {
    Column(modifier = Modifier
        .fillMaxWidth()) {
        Text("Listagem")
//        for( contato in contatovm.lista.value ) {
            LazyColumn {
                items( contatovm.lista.value ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(color = Color.LightGray, shape = RoundedCornerShape(30.dp))
                            .padding(10.dp)
                    ) {
                        Text(it.nome)
                        Text(it.email)
                        Text(it.telefone)
                    }
                }
            }
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    val contatoViewModel = viewModel{ ContatoViewModel() }
    contatoViewModel.navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Agenda de Contato") }, actions = {
                IconButton(onClick = {contatoViewModel.formulario()}) {
                    Icon(Icons.Default.Edit, "Formulario")
                }
                IconButton(onClick = {contatoViewModel.listagem()}) {
                    Icon(Icons.Default.List, "Listagem")}
            })
        },
        floatingActionButton =
            { FloatingActionButton(onClick = {contatoViewModel.formulario()}) {Text("+")} },
        snackbarHost = {
            SnackbarHost( contatoViewModel.snackMessage.value )
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {
                        contatoViewModel.adicionar()
                        // snackMessage.value.showSnackbar("Contato adicionado com sucesso")
                    },
                    contentPadding = PaddingValues(10.dp, 5.dp, 10.dp, 5.dp),
                ) {
                    Text("Salvar")
                }
                Button(
                    onClick = {
                        contatoViewModel.pesquisar()
                    },
                    contentPadding = PaddingValues(10.dp, 5.dp, 10.dp, 5.dp),
                ) {
                    Text("Pesquisar")
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            NavHost(contatoViewModel.navController, startDestination = "FORM") {
                composable("FORM") {
                    ContatoFormulario(contatoViewModel)
                }
                composable( "LISTA") {
                    ContatoListagem( contatoViewModel)
                }
            }
        }
    }
}