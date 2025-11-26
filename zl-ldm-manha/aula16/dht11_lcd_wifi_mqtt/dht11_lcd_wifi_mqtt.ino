#include <DHT.h>
#include <LiquidCrystal_I2C.h>
#include <WiFi.h>
#include <PubSubClient.h>

#define SENSOR_PIN 5
#define LCD_SDA 23
#define LCD_SCL 22

const char* ssid = "Tom Galaxy A35";
const char* password = "1011121314";
const char* mqtt_server = "10.209.152.237";
const int mqtt_port = 1883;
const char* mqtt_topic = "sensor/dht11";

DHT dht11(SENSOR_PIN, DHT11);
LiquidCrystal_I2C lcd(0x27, 16, 2);
WiFiClient espClient;
PubSubClient mqttClient( espClient );

int status_connection = 0;
  // 0 - Não houver conexão nenhuma
  // 1 - Quando estiver conectado no Wifi
  // 2 - Quando estiver conectado no Wifi e no Broker

void conectarWifi() {
  Serial.begin(115200);
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  Serial.println("IoT Temperatura e Umidade iniciando...");
  lcd.clear();
  lcd.setCursor(0, 0);
  Serial.printf("Buscando Wifi %s ", ssid);
  lcd.print("Wifi: ");
  lcd.print(ssid);
  lcd.setCursor(0, 1);
  lcd.print(".");
  while (WiFi.status() != WL_CONNECTED) { 
    status_connection = 0;
    delay(500);
    lcd.print(".");
    Serial.print(".");
  }
  status_connection = 1;
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("Connected");
  Serial.println("Connected");
  delay(1000);

  // ( )  Não está conectado nem no Wifi
  // (#)  Conectado no Wifi
  // (*)  Conectado no Mosquitto via MQTT
}

void setup() {
  dht11.begin();
  lcd.init();
  lcd.backlight();
  conectarWifi();
  if (status_connection == 1) { 
    mqttClient.setServer( mqtt_server, mqtt_port );
  }
}

void mqtt_connect() { 
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("Connecting MQTT");
  Serial.print("Conectando MQTT ");
  lcd.setCursor(0, 1);
  while (!mqttClient.connected()) { 
    status_connection = 1;
    lcd.print(".");
    Serial.print(".");
    mqttClient.connect("ESP32Client");
  }
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("MQTT Connected");
  Serial.println("\nConectado ao MQTT");
  status_connection = 2;
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(10000); // this speeds up the simulation

  float umi  = dht11.readHumidity();
  float tempC = dht11.readTemperature();

  lcd.clear();

  lcd.setCursor(0, 0);
  lcd.print("Temp: ");
  lcd.print(tempC);
  lcd.setCursor(0, 1);
  lcd.print("Umid: ");
  lcd.print(umi);
  lcd.setCursor(13, 0);
  Serial.printf("Temp: %5.2f\tUmid: %5.2f\n", tempC, umi);
  if (status_connection == 1) { 
    lcd.print("(#)");
  } else if (status_connection == 2) { 
    lcd.print("(*)");
  } else { 
    lcd.print("( )");
  }

  if (!mqttClient.connected()) { 
    mqtt_connect();
  } else { 
    // "{\"temp\": 19.8, \"umd\": 42.5}"
    tempC = 28.4;
    umi = 63.0;
    if (!isnan(tempC) && !isnan(umi)) {
      String carga = "{\"temp\":" + String(tempC) + ", \"umd\":" + String(umi) + "}";
      Serial.printf("Enviando: %s \n", carga.c_str());
      mqttClient.publish(mqtt_topic, carga.c_str());
    }
    delay(10000);
  }

}
