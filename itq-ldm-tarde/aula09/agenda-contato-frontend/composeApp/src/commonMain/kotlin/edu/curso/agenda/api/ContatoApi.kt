package edu.curso.agenda.api

import edu.curso.agenda.model.Contato
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ContatoApi(val httpClient : HttpClient) {
    private val URL_BASE = "http://192.168.68.104:8080"
    suspend fun adicionarApi( contato : Contato) {
        httpClient.post("$URL_BASE/contato") {
            contentType(ContentType.Application.Json)
            setBody(contato)
        }
    }

    suspend fun pesquisarApi() : List<Contato> =
        httpClient.get("$URL_BASE/contato").body()
}