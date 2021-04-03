import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.BasicConfigurator;


public class Server {
    
    String name = "";

   Context ictx = null;
   
	


 

//Creare il contesto
   public static void main (String[] args) throws NamingException, JMSException{
        BasicConfigurator.configure();
       
		Random randomGen = new Random();
		float val = randomGen.nextFloat() * 20;
		
      
        
        String landedA[] = { "False", "True" };
        
        

	 String title;
		int whichMsg;
		

		whichMsg = randomGen.nextInt(landedA.length);
		String landed = landedA[whichMsg];
	
        
            Properties props = new Properties();
        
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            Context jndiContext = new InitialContext(props);        
                
            
                MessageProducer producer = null;
                String destinationName = "dynamicTopics/Quotazioni";

        
           ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
            Destination destination = (Destination)jndiContext.lookup(destinationName);
             props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
             Connection conn = connectionFactory.createConnection();
             Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);
            
             TextMessage message = null;
             
             
             int i = 0;
             
             while (true) {
			i++;
             
                        byte[] array = new byte[4]; // length is bounded by 7
    new Random().nextBytes(array);
    String generatedName = new String(array, Charset.forName("UTF-8"));
		
                
			float quotazione = val;
		
                message = session.createTextMessage();
                
                message.setStringProperty("Landed", landed);
                message.setStringProperty("Name", generatedName);
			
			message.setText(
					"Item " + i + ": " + generatedName + ", Landed: "
					+ landed);

			 

			producer.send(message);
                        
                        try {
				Thread.sleep(5000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
                        
              



        } }
} 
  
                                                             
                                                        
       
      

   

   
    

