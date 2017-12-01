/**
 * 
 */
package tay.resource;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.twilio.Twilio;


/**
 * @author toby
 *
 */

@Path("send")
public class MessageSendResource {
	
	@GET
	public void sendText() {
		
	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message
            .creator(new PhoneNumber("To Number"),
                     new PhoneNumber("Twilio From number"),  // from
                     "Message you want to send here")
            .create();
	}

}
