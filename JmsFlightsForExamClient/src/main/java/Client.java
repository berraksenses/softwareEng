
import static java.lang.System.setProperty;
import java.util.Observable;
import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.log4j.BasicConfigurator;



    public class Client {

    private TopicConnection topicConnection; 
    private TopicSession topicSession = null; 
    private Destination destination = null;
    

     public static void main (String[] args) throws NamingException, JMSException    {
         BasicConfigurator.configure();

        Properties props = new Properties();
           props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            Context jndiContext = new InitialContext(props);        
                
            
                MessageProducer producer = null;
                String destinationName = "dynamicTopics/Quotazioni";

        
           ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
            Destination destination = (Destination)jndiContext.lookup(destinationName);
             props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
             TopicConnection conn = (TopicConnection) connectionFactory.createConnection();
               TopicSession topicSession = (TopicSession) conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

             TopicSubscriber topicSubscriber = topicSession.createSubscriber((Topic) destination);
                         topicSubscriber.setMessageListener(new FlightLstnr());
                         conn.start();

    }
        
        
   
    
}
