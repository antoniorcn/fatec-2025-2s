package edu.curso.agenda.service

import edu.curso.agenda.model.Medicao
import edu.curso.agenda.repository.MedicaoRepositoryDB
import jakarta.annotation.PostConstruct
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MedicaoService(
    @Value("\${mqtt.uri}") private val mqttURI: String = "",
    private val medicaoRepositoryDB: MedicaoRepositoryDB
) {
    private val logger : Logger = LoggerFactory.getLogger(MedicaoService::class.java)
    private val cliente = MqttClient(mqttURI,
        MqttClient.generateClientId(),
        MemoryPersistence()
    )
    @PostConstruct
    fun iniciar() {
        logger.info("MQTTServiceSubscriber:iniciar() - invocado")
        logger.info("MQTTClient - $cliente")

        cliente.connect()

        cliente.subscribe("iot/sensor1") {
            topico : String, message : MqttMessage ->
            val texto = String(message.payload)
            logger.info("\nTopico ($topico)")
            logger.info("Informações adicionais:")
            logger.info("Id: ${message.id}")
            logger.info("Qos: ${message.qos}")
            logger.info("Payload: $texto")
            logger.info("Duplicate: ${message.isDuplicate}")
            logger.info("Retained: ${message.isRetained}")
            // {"temp": 21.8, "umd": 43.5}
            val jsonObject  = Json.decodeFromString<JsonObject>( texto )
            val temp = jsonObject.get("temp")?.toString()?.toDouble()
            val umd = jsonObject.get("umd")?.toString()?.toDouble()
            logger.info("Temperatura: $temp")
            logger.info("Umidade: $umd")

            val medicao = Medicao(null, temp?:0.0, umd?:0.0)
            medicaoRepositoryDB.save( medicao )
        }
    }
}