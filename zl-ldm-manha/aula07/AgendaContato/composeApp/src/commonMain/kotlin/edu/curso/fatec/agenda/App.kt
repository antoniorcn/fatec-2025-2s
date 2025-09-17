@file:OptIn(ExperimentalMaterial3Api::class)

package edu.curso.fatec.agenda

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun Teste() {
    val meuBotaoEstilo = ButtonDefaults.buttonColors(
        containerColor = Color.Yellow, disabledContainerColor = Color.DarkGray,
        contentColor = Color.Black, disabledContentColor = Color.LightGray
    )
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding( 20.dp)
                .border(2.dp, Color.Yellow, shape = RoundedCornerShape(30.dp))
                .background(Color.LightGray, shape = RoundedCornerShape(30.dp))
                .padding( 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Olá Mundo", color = Color.Blue)
            Text("Bem vindo ao App feito em Kotlin Multiplataforma",
                color = Color.Green, overflow = TextOverflow.MiddleEllipsis,
                maxLines = 3)
            Text("criado por: Antonio Carvalho", color = Color.Red)
            Row {
                Text("Digite seu nome: ")
                TextField(value = "", onValueChange = {},
                    placeholder = { Text("Nome completo") },
                    label = { Text("Digite seu nome: " )},
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrectEnabled = true,
                        keyboardType = KeyboardType.Number,
                        hintLocales = LocaleList(Locale.current)
                    )
                )
            }
            Button( onClick = {}, contentPadding =
                PaddingValues(3.dp), colors = meuBotaoEstilo)
            {
                Text("Clique Me")
            }

        }
    }
}

@Composable
fun AgendaContato() { 
    MaterialTheme {
        Column (modifier =
            Modifier.fillMaxSize()
                .padding(20.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(30.dp))
                .padding(30.dp)
                .clickable{ println("Tela clicada")}
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8F),
                verticalArrangement = Arrangement.SpaceEvenly,
                Alignment.Start
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        // .padding(0.dp, 10.dp, 0.dp, 0.dp)
                        .background(
                            Color.Cyan,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    value = "",
                    onValueChange = {},
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
                    value = "",
                    onValueChange = {},
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
                    value = "",
                    onValueChange = {},
                    // shape = RoundedCornerShape(10.dp),
                    label = { Text("Telefone:") },
                    placeholder = { Text("DDD e Telefone:") }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .fillMaxHeight(0.2F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Button(onClick = {}) {
                        Text("Adicionar")
                    }
                    Button(onClick = {}) {
                        Text("Pesquisar")
                    }
                }
            }
        }
    }
}

data class Contato(
    val nome : String,
    val telefone : String,
    val email : String
)

val nome : MutableState<String> = mutableStateOf("")
val telefone : MutableState<String> = mutableStateOf("")
val email : MutableState<String> = mutableStateOf("")

val lista : MutableState<List<Contato>> = mutableStateOf( listOf())

@Composable
fun AgendaContatoScaffold() {
    MaterialTheme {
        Scaffold(
            bottomBar = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        val contato = Contato(nome = nome.value,
                            telefone = telefone.value,
                            email = email.value)
                        val listaNova : MutableList<Contato> = mutableListOf()
                        listaNova.addAll( lista.value )
                        listaNova.add( contato )
                        lista.value = listaNova
                    }) {
                        Text("Adicionar")
                    }
                    Button(onClick = {
                        for (contato in lista.value) {
                            if (contato.nome.contains( nome.value )) {
                                nome.value = contato.nome
                                telefone.value = contato.telefone
                                email.value = contato.email
                            }
                        }
                    }) {
                        Text("Pesquisar")
                    }
                }
            },
            topBar = {
                TopAppBar( title = { Text(text = "Agenda de Contato",
                    fontSize = 32.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center) } )
            }

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding( it ),
                verticalArrangement = Arrangement.SpaceEvenly,
                Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        // .padding(0.dp, 10.dp, 0.dp, 0.dp)
                        .background(
                            Color.Cyan,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    value = nome.value,
                    onValueChange = { nome.value = it },
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
                    value = email.value,
                    onValueChange = {email.value = it},
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
                    value = telefone.value,
                    onValueChange = {telefone.value = it},
                    // shape = RoundedCornerShape(10.dp),
                    label = { Text("Telefone:") },
                    placeholder = { Text("DDD e Telefone:") }
                )
            }
        }
    }
}

@Composable
@Preview
fun App() {
    AgendaContatoScaffold()
}