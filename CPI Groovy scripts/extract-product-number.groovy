import com.sap.gateway.ip.core.customdev.util.Message;
import groovy.json.*

def Message processData(Message message) {
    def json = new JsonSlurper().parseText(message.getBody(String));
    message.setHeader('PRODUCT',json.data.KEY[0].PRODUCT);
    message.setHeader('eventType',json.eventType);

    return message;
}