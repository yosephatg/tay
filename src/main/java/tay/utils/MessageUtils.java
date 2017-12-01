/**
 * 
 */
package tay.utils;

import java.util.HashMap;

/**
 * @author toby
 *
 */
public class MessageUtils {
	
	public static HashMap<String, String> requestToMap(String request) {
		HashMap<String, String> requestItems = new HashMap<String, String>();
		String[] requestArr = request.split("&");
		
		for (String item : requestArr) {
			String[] itemArr = item.split("=");
			if (itemArr.length > 1) {
				requestItems.put(itemArr[0], itemArr[1]);
			} else {
				requestItems.put(itemArr[0], "Empty");
			}
		}
		
		return requestItems;
		
	}

}
