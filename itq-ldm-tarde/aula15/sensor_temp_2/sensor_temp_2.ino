#include <DHT.h>
#include <DHT_U.h>
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);

#define DHTPIN 5

DHT dht11(DHTPIN, DHT11);
void setup() {
  dht11.begin();
  lcd.init();
  lcd.backlight();
  Serial.begin(115200);
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

  if ( !isnan(temperatura) && !isnan(umidade)) { 
    Serial.printf("Temperatura: %5.2f    Umidade: %5.2f\n", temperatura, umidade);
  } else { 
   Serial.println("Erro ao ler dados do sensor");
  }
  delay( 1000 );
}
