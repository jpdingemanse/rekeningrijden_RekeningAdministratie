/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author lino_
 */
public class JMSSender {
    
    // You can create any/many queue names as per your requirement.
    public static void sendInvoiceInternal(String bericht, String url, String subject) {
        try {
            // Getting JMS connection from the server and starting it
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            // JMS messages are sent and received using a Session. We will
            // create here a non-transactional session object. If you want
            // to use transactions you should set the first parameter to 'true'
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // Destination represents here our queue 'VALLYSOFTQ' on the
            // JMS server. You don't have to do anything special on the
            // server to create it, it will be created automatically.
            Destination destination = session.createQueue(subject);
            // MessageProducer is used for sending messages (as opposed
            // to MessageConsumer which is used for receiving them)
            MessageProducer producer = session.createProducer(destination);
            // We will send a small text message saying 'Hello' in Japanese
            TextMessage message = session.createTextMessage(bericht);
            // Here we are sending the message!
            producer.send(message);
            System.out.println("Sending '" + message.getText() + "'");
            
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException ex) {

        }
    }
}
