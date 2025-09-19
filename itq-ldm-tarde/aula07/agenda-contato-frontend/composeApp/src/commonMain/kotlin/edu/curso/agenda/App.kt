package edu.curso.agenda

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


data class Contato (
    val nome : String,
    val email : String,
    val telefone : String
)


val nome : MutableState<String> = mutableStateOf("")
val email : MutableState<String> = mutableStateOf("")
val telefone : MutableState<String> = mutableStateOf("")

val lista : MutableState<List<Contato>> = mutableStateOf( listOf() )

val snackMessage : MutableState<SnackbarHostState> =
        mutableStateOf(SnackbarHostState() )

@Composable
@Preview
fun App() {
    Scaffold(
        topBar = {Text("Agenda de Contato")},
        floatingActionButton =
            { FloatingActionButton(onClick = {}) {Text("+")} },
        snackbarHost = {
            SnackbarHost( snackMessage.value )
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {
                        val contato = Contato( nome.value,
                           email.value,
                           telefone.value)
                        val listaNova : MutableList<Contato> = mutableListOf()
                        listaNova.add( contato )
                        listaNova.addAll( lista.value )
                        lista.value = listaNova
                        print("Contato $contato adicionado com sucesso")
                        print(lista.value)
                        // snackMessage.value.showSnackbar("Contato adicionado com sucesso")
                    },
                    contentPadding = PaddingValues(10.dp, 5.dp, 10.dp, 5.dp),
                ) {
                    Text("Salvar")
                }
                Button(
                    onClick = {
                        for (c in lista.value) {
                            if (c.nome.contains( nome.value )) {
                                nome.value = c.nome
                                email.value = c.email
                                telefone.value = c.telefone
                                break
                            }
                        }
                    },
                    contentPadding = PaddingValues(10.dp, 5.dp, 10.dp, 5.dp),
                ) {
                    Text("Pesquisar")
                }
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                //            .fillMaxHeight()
                //            .fillMaxWidth()
                .fillMaxSize()
                .padding( it )
                .padding(10.dp, 30.dp)
                .background( color = Color.White,
                    shape = RoundedCornerShape(30.dp)
                )
//                .border(
//                    2.dp,
//                    color = Color.Blue,
//                    shape = RoundedCornerShape(30.dp)
//                )
                .padding(15.dp, 30.dp)

            //            .clickable { println("Painel clicado") }

        ) {
            TextField(
                value = nome.value, onValueChange = { nome.value = it },
                label = { Text("Nome completo") },
                placeholder = { Text("Informe seu nome completo") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = email.value, onValueChange = { email.value = it },
                label = { Text("Email") },
                placeholder = { Text("Informe um email valido") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = telefone.value, onValueChange = { telefone.value = it },
                label = { Text("Telefone") },
                placeholder = { Text("Informe seu DDD e telefone") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}