package br.com.mineqtt;

import org.bukkit.Bukkit;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class ClientMQTT {

    static String broker = "tcp://broker.hivemq.com:1883";
    static String topic = "mineqtt";
    static String clientId = "java";


    public static void publish(String content) {
        try {
            MqttClient client = new MqttClient(broker, clientId);
            MqttMessage message = new MqttMessage(content.getBytes());
            client.connect();
            client.publish(topic, message);
            client.disconnect();
        } catch(Exception e){
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        }
    }
}
