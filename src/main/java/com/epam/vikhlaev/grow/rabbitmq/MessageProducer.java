package com.epam.vikhlaev.grow.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;

public class MessageProducer {


    public static void main(String[] args) {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();
        ) {


            String exchangeName = "myExchange";
            String routingKey = "testRoute";

            for (int i = 0; i < 10000000; i++) {
                String dataStr = "data:" + i + ";";
                byte[] data = (dataStr).getBytes(StandardCharsets.UTF_8);
                channel.basicPublish(exchangeName, routingKey, MessageProperties.PERSISTENT_BASIC, data);
                System.out.println(dataStr);
            }


           // Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finish");
        }


    }

}
