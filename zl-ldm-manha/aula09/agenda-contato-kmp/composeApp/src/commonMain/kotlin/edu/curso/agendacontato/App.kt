package edu.curso.agendacontato

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DynamicForm
import androidx.compose.material.icons.filled.FilterListOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ContatoFormulario(viewModel: ContatoViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding( 10.dp ),
        verticalArrangement = Arrangement.Top
    ) {
        Text("Formulario")
        OutlinedTextField(
            modifier = Modifier
                // .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .background(
                    Color.Cyan,
                    shape = RoundedCornerShape(10.dp)
                ),
            value = viewModel.nome.value,
            onValueChange = { viewModel.nome.value = it },
            // shape = RoundedCornerShape(10.dp),
            label = { Text("Nome:") },
            placeholder = { Text("Nome Completo:") }
        )
        OutlinedTextField(
            modifier = Modifier
                // .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .background(
                    Color.Cyan,
                    shape = RoundedCornerShape(10.dp)
                ),
            value = viewModel.email.value,
            onValueChange = {viewModel.email.value = it},
            // shape = RoundedCornerShape(10.dp),
            label = { Text("Email:") },
            placeholder = { Text("Email Valido:") }
        )
        OutlinedTextField(
            modifier = Modifier
                // .padding(0.dp, 10.dp, 0.dp, 0.dp)
                .background(
                    Color.Cyan,
                    shape = RoundedCornerShape(10.dp)
                ),
            value = viewModel.telefone.value,
            onValueChange = {viewModel.telefone.value = it},
            // shape = RoundedCornerShape(10.dp),
            label = { Text("Telefone:") },
            placeholder = { Text("DDD e Telefone:") }
        )
    }
}

@Composable
fun ContatoCard( contato : Contato ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp)
            .background( color = Color.LightGray,
                shape = RoundedCornerShape(30.dp) )
            .padding(5.dp)
    ) {
        Text(contato.nome)
        Text(contato.telefone)
        Text(contato.email)
    }
}

@Composable
fun ContatoListagem(viewModel: ContatoViewModel) {
    Text("Listagem")
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.5f)
        .background(color = Color.Yellow)
    ) {
        items (viewModel.lista.value) { contato ->
            ContatoCard( contato )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgendaContatoScaffold() {
    MaterialTheme {
        val viewModel : ContatoViewModel = viewModel { ContatoViewModel()  }
        val navController = rememberNavController()

        Scaffold(
            bottomBar = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        viewModel.adicionar()
                    }) {
                        Text("Adicionar")
                    }
                    Button(onClick = {
                        viewModel.pesquisar()
                    }) {
                        Text("Pesquisar")
                    }
                }
            },
            snackbarHost = {
                SnackbarHost( hostState = viewModel.snackbarHostState.value )
            },
            topBar = {
                TopAppBar(
                    title = { Text(text = "Agenda de Contato",
                        fontSize = 32.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                        },
                    actions = {
                        IconButton( onClick = { navController.navigate("FORM") }) {
                            Icon(Icons.Default.DynamicForm, "Formulario")
                        }
                        IconButton( onClick = { navController.navigate("LISTA") }) {
                            Icon(Icons.Default.FilterListOff, "Listagem")
                        }
                    }
                )
            }
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(it)) {
                NavHost( navController = navController, startDestination = "FORM" ) {
                    composable( "FORM" ) {
                        ContatoFormulario( viewModel )
                    }

                    composable( "LISTA" ) {
                        ContatoListagem( viewModel )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun App() {
    AgendaContatoScaffold()
}