#include <DHT.h>
#include <DHT_U.h>

#define SENSOR_PIN 5
DHT dht11(SENSOR_PIN, DHT11);
void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  Serial.println("Leitor de Temperatura e Umidade");
  dht11.begin();
}
void loop() {
  float tempC = dht11.readTemperature();
  float umid = dht11.readHumidity();
  if (!isnan(tempC) && !isnan(umid)) { 
    Serial.printf("Temperatura: %5.2f    Umidade: %5.2f \n", tempC, umid);
  }  
  delay(1000); // this speeds up the simulation
}
