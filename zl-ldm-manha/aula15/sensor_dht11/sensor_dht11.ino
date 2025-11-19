#include <DHT.h>
#include <DHT_U.h>
#define DHTPIN 5
DHT dht11(DHTPIN, DHT11);
void setup() {
  dht11.begin();
  Serial.begin(115200);
}
void loop() {
  float umidade = dht11.readHumidity();
  float temperatura = dht11.readTemperature();
  if ( !isnan(temperatura) && !isnan(umidade)) { 
    Serial.printf("Temperatura: %5.2f    Umidade: %5.2f\n", temperatura, umidade);
  } else { 
   Serial.println("Erro ao ler dados do sensor");
  }
  delay( 1000 );
}
