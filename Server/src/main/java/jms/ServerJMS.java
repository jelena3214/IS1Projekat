/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import commands.Command;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 *
 * @author Lenovo
 */
public class ServerJMS {
    @Resource(lookup="jms/__defaultConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup="s1Queue")
    private Queue sub1Queue;

    @Resource(lookup="s2Queue")
    private Queue sub2Queue;

    @Resource(lookup="s3Queue")
    private Queue sub3Queue;

    @Resource(lookup="serverQueue")
    private Queue serverQueue;
    
    public List<Queue> getDestinationQueues(Command.DestQueue dest){
        switch(dest){
            case S1: return new ArrayList<Queue>(){{add(sub1Queue);}};
            case S2: return new ArrayList<Queue>(){{add(sub2Queue);}};
            case S3: return new ArrayList<Queue>(){{add(sub3Queue);}};
        }
        
        return new ArrayList<Queue>();
    }
    
    public Serializable communicate(Command command){
        List<Queue> destinations = getDestinationQueues(command.getDestination());
        
        if(destinations.isEmpty()){
            System.err.println("Destination list is empty");
            return null;
        }
        
        JMSContext context = connectionFactory.createContext();
        JMSConsumer consumer = context.createConsumer(serverQueue);
        JMSProducer producer = context.createProducer();
        
        Message msg;
        while ((msg = consumer.receiveNoWait()) != null) {
            System.out.println("Discarding message " + msg);
        }
        
        for(Queue qu: destinations){
            try {
                ObjectMessage objMsg = context.createObjectMessage(command);
                objMsg.setJMSReplyTo(serverQueue);
                System.out.println("Server sending " + command);
                
                producer.send(qu, objMsg);
                Message response = consumer.receive(5000);
                if (!(response instanceof ObjectMessage)) {
                    System.err.println("Received message is not an ObjectMessage: " + response);
                }
                
                Serializable obj = ((ObjectMessage)response).getObject();
                System.out.println("Response: " + obj);
                return obj;
            } catch (JMSException ex) {
                Logger.getLogger(ServerJMS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        return null;
    }
}
