#define PINO_SAIDA 5

void setup() {
  pinMode(PINO_SAIDA, OUTPUT);
}

void loop() {
  digitalWrite(PINO_SAIDA, HIGH);
  delay(1000);
  digitalWrite(PINO_SAIDA, LOW);
  delay(1000);
}