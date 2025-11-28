#include <WiFi.h>
#include <DHT.h>
#include <DHT_U.h>
#include <LiquidCrystal_I2C.h>
#include <PubSubClient.h>


LiquidCrystal_I2C lcd(0x27, 16, 2);
WiFiClient espClient;
PubSubClient mqttClient( espClient );

const char* NET_SSID="BarberiniTaboao";
const char* NET_PASS="26042021";
const char* MQTT_SERVER="192.168.68.103";
const int MQTT_PORT=1883;
const char* MQTT_TOPIC="sensor/dht11";




#define DHTPIN 5

DHT dht11(DHTPIN, DHT11);

void connectWiFi() { 
  WiFi.mode(WIFI_STA);
  WiFi.begin(NET_SSID, NET_PASS);
  Serial.printf("Conectando Wifi %s: ", NET_SSID);
  while(WiFi.status() != WL_CONNECTED) { 
    Serial.print(".");
    delay( 500 );
  }
  Serial.println("Conectado WiFi");
}

void connectMqtt() {
  mqttClient.setServer(MQTT_SERVER, MQTT_PORT);
  Serial.printf("Conectando MQTT Server %s:%d => ", MQTT_SERVER, MQTT_PORT);
  while(  !mqttClient.connected() ) { 
    mqttClient.connect("ESP32Client");
    Serial.print(".");
  }
} 

void setup() {
  dht11.begin();
  lcd.init();
  lcd.backlight();
  Serial.begin(115200);
  connectWiFi();
  connectMqtt();
}

void loop() {
  float umidade = dht11.readHumidity();
  float temperatura = dht11.readTemperature();

  lcd.clear();

  lcd.setCursor(0, 0);
  lcd.print("Temp:");
  lcd.setCursor(0, 6);
  lcd.print(temperatura);

  lcd.setCursor(1, 0);
  lcd.print("Umid:");
  lcd.setCursor(1, 6);
  lcd.print(umidade);

  temperatura = 29.5;
  umidade = 54.2;

  if ( !isnan(temperatura) && !isnan(umidade)) { 
    Serial.printf("Temperatura: %5.2f    Umidade: %5.2f\n", temperatura, umidade);
    String carga = "{\"temp\":" + String(temperatura) + ", \"umid\":" + String(umidade) +  "}";
    if (!mqttClient.connected()) { 
      connectMqtt();
    } else { 
      mqttClient.publish( MQTT_TOPIC, carga.c_str() );
      Serial.printf("Enviado %s  para o tópico ==> %s  \n", carga.c_str(), MQTT_TOPIC);
    }
  } else { 
   Serial.println("Erro ao ler dados do sensor");
  }
  delay( 3000 );
}
