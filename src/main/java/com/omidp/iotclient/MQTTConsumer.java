package com.omidp.iotclient;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.Message;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;

/**
 * @author omidp
 *
 */
public class MQTTConsumer {
	public static void main(String[] args) throws Exception {
		MQTT mqtt = new MQTT();
		mqtt.setHost("tcp://localhost:1883");
		mqtt.setClientId("123pub");
		mqtt.setCleanSession(true);
		BlockingConnection connection = mqtt.blockingConnection();
		connection.connect();
		//
		Topic[] topics = { new Topic("foo", QoS.AT_LEAST_ONCE) };
		byte[] qoses = connection.subscribe(topics);
		Message message = connection.receive();
		byte[] payload = message.getPayload();
		// process the message then:
		System.out.println("##################");
		System.out.println(message.getTopic());
		System.out.println(new String(payload));
		System.out.println("##################");
		message.ack();
		connection.disconnect();
	}
}
