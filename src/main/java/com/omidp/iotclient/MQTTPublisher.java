package com.omidp.iotclient;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;

public class MQTTPublisher {

	public static void main(String[] args) throws Exception {
		MQTT mqtt = new MQTT();
		mqtt.setHost("tcp://localhost:1883");
		mqtt.setClientId("12345pub");
		mqtt.setCleanSession(true);
		BlockingConnection connection = mqtt.blockingConnection();
		connection.connect();
		connection.publish("foo", "Hello".getBytes(), QoS.AT_LEAST_ONCE, false);
		connection.disconnect();
	}

}
