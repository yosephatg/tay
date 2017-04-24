package tay.resource;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

import tay.utils.MessageUtils;



@Path("receive")
public class MessageReceiveResource {

	@POST
	public Response textMe(String request) throws ServletException {
		//Calls util class to transform request into readable map
		HashMap<String, String> requestMap = MessageUtils.requestToMap(request);
		
		try{
		    PrintWriter writer = new PrintWriter("path/to/file", "UTF-8");
		    writer.println(requestMap.toString());
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
		//Build message to respond with (Necessary for Twilio API, can respond with
		//nothing if we want
		Message message = new Message.Builder()
				.body(new Body("This is a response"))
				.build();
		
		MessagingResponse response = new MessagingResponse.Builder().message(message).build();
		try {
			//return messaging response in XML per Twilio API
			return Response.ok(response.toXml()).type("application/xml").build();
		} catch (TwiMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
}