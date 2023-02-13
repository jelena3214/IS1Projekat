/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsystem3;

import commands.Command;
import commands.CommandExecuter;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo
 */
public class Subsystem3 {

    @Resource(lookup="konekcija", type = ConnectionFactory.class)
    static ConnectionFactory connectionFactory;

    @Resource(lookup="s3Queue")
    static Queue s3Queue;

    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaEEsub3PU");
        EntityManager em = emf.createEntityManager();
        try {
            JMSContext context = connectionFactory.createContext();
            JMSConsumer consumer = context.createConsumer(s3Queue);
            JMSProducer producer = context.createProducer();
            CommandExecuter executer = new CommandExecuter();
            
            Message msg;
            while ((msg = consumer.receiveNoWait()) != null) {
                System.out.println("Discarding message " + msg);
            }
            
            System.out.println("Subsystem3 started");
            while(true){
                System.out.println("Subsystem3 waiting...");
                msg = consumer.receive();
                Destination replyTo = msg.getJMSReplyTo();
                if (replyTo == null || !(replyTo instanceof Queue)) {
                    System.err.println("JMS-Reply-To is invalid: " + msg);
                }
                if (!(msg instanceof ObjectMessage)) {
                    System.err.println("Message is not an ObjectMessage: " + msg);
                }
                Serializable obj = ((ObjectMessage)msg).getObject();
                if (!(obj instanceof Command)) {
                    System.err.println("Received object is not a command: " + obj);
                }
                Command cmd = (Command)obj;
                Serializable res = executer.executeCommand(cmd, em);
                
                ObjectMessage response = context.createObjectMessage(res);
                producer.send(replyTo, response);
                
                System.out.println("Response sent: \n" + response.getObject().toString());
                
            }
        } catch (JMSException ex) {
            Logger.getLogger(Subsystem3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
