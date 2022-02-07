package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data = null;
		
		data = message.getData();
		segment = new byte [SEGMENTSIZE];
		
	
		segment[0] = (byte) message.getData().length;
		for (int i = 1; i <= message.getData().length; i++) {
			segment[i] = data[i - 1];
		}
		
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messagin layer
		
	
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// decapsulate segment and put received data into a message
		
		int lengde = segment[0];
		
		byte [] data = new byte [lengde];
		
		for (int i = 1; i <= lengde; i++) {
			data[i - 1] = segment [i];
		}
		
		
		message = new Message(data); 

		return message;
		
	}
	
}
