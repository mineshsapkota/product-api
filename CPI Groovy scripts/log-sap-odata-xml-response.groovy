import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;

def Message processData(Message message) {

   def map = message.getHeaders();
   def PRODUCT = map.get("PRODUCT");
   
   def body = message.getBody(java.lang.String) as String;
   def messageLog = messageLogFactory.getMessageLog(message);

    //Properties
    def properties = message.getProperties();
    
   String sBody = "OData PRODUCT " + PRODUCT + " Details XML from S4 HANA";


   if(messageLog != null) {
       messageLog.setStringProperty(sBody, body);
       messageLog.addAttachmentAsString(sBody, body, 'text/xml');
    }

   return message;
}