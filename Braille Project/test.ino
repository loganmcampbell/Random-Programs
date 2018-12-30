int d1, d2, d3, d4, d5, d6, d7, d8, d9;
void setup()
{
  // Initalize serial COM at 9600 baud rate
  // Baud rate: is the rate at which information is transferred in a communication channel.
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  pinMode(12, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(9,  OUTPUT);
  pinMode(8,  OUTPUT);
  pinMode(7,  OUTPUT);
  pinMode(6,  OUTPUT);
  pinMode(5,  OUTPUT);

  for(int ports = 0; ports < 16; ports++)
  {
    digitalWrite (ports, LOW);
  }
  Serial.println("Connection established...");
}

 void triggerPin(int pin)
 {
    digitalWrite(pin,HIGH);
    
 }
 void offPin(int pin)
 {
    digitalWrite(pin,LOW);
 }
 
void loop()
{

  if (Serial.available())
  {
    char ser = Serial.read();
    Serial.println(ser);

    switch (ser)
    {
      case '0':
      triggerPin(13);
      break;

      case '1':
      triggerPin(12);
      break;
      
      case '2':
      triggerPin(11);
      break;

            
      case '3':
      triggerPin(10);
      break;
      
      case '4':
      triggerPin(9);
      break;
      
      case '5':
      triggerPin(8);
      break;
      
      case '6':
      triggerPin(7);
      break;
      
      case '7':
      triggerPin(6);
      break;
      
      case '8':
      triggerPin(5);
      break;
      
      case 'A' :
      offPin(13);
      break;

      case 'B' :
      offPin(12);
      break;

      case 'C' :
      offPin(11);
      break;
      
      case 'D' :
      offPin(10);
      break;

      case 'E' :
      offPin(9);
      break;

      case 'F' :
      offPin(8);
      break;

      case 'G' :
      offPin(7);
      break;

      case 'H' :
      offPin(6);
      break;

      case 'I' :
      offPin(5);
      break;
    }
    
  }
}
