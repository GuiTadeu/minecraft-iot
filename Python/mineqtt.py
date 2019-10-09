import paho.mqtt.client as mqtt
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BOARD)
GPIO.setup(32, GPIO.OUT)

def on_connect(client, userdata, flags, rc):
  client.subscribe("mineqtt")

def on_message(client, userdata, msg):
  if msg.payload == "on":
    GPIO.output(32, 1)
  if msg.payload == "off":
    GPIO.output(32, 0)

client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message
client.connect("broker.hivemq.com", 1883, 8000)
client.loop_forever()
