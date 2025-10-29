package edu.curso.agenda.service

import edu.curso.agenda.model.Medicao
import edu.curso.agenda.repository.MedicaoRepository
import jakarta.annotation.PostConstruct
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.JsonObject

@Service
class MedicaoService(
    private val medicaoRepository: MedicaoRepository
) {
    val logger : Logger = LoggerFactory.getLogger(MedicaoService::class.java)

    @PostConstruct
    fun inicializacao() {
        logger.info("MedicaoService:incializacao() - executada")
        val clientId = MqttClient.generateClientId()
        val serverURI = "tcp://localhost:1883"
        val mqttClient = MqttClient(serverURI, clientId)
        mqttClient.connect()
        mqttClient.subscribe("sensor/#") {
            topico : String, msg : MqttMessage ->
            try {
                val texto: String = msg.toString()
                logger.info("Topico ==> $topico")
                logger.info("Mensagem id ==>${msg.id}")
                logger.info("Mensagem QoS ==>${msg.qos}")
                logger.info("Mensagem Duplicate ==>${msg.isDuplicate}")
                logger.info("Mensagem Retained ==>${msg.isRetained}")
                logger.info("Mensagem Conteudo ==>$texto")
                // {"temp": 21.8, "umd": 43.5}
                val jsonObj = Json.decodeFromString<JsonObject>(texto)
                val medicao = Medicao(
                    id = null,
                    temperatura = jsonObj.get("temp").toString().toDouble(),
                    umidade = jsonObj.get("umd").toString().toDouble(),
                    sensor = topico
                )
                medicaoRepository.save(medicao)
            } catch ( exception : Exception ) {
                logger.trace(exception.toString())
            }
        }
    }
}