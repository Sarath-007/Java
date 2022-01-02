package org.sarath.restAPI.messenger2.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.UriInfo;

import org.sarath.restAPI.messenger2.database.DatabaseClass;
import org.sarath.restAPI.messenger2.exception.DataNotFoundException;
import org.sarath.restAPI.messenger2.messageresource.MessageResource;
import org.sarath.restAPI.messenger2.messageresource.ProfileResource;
import org.sarath.restAPI.messenger2.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	public MessageService() {
			messages.put(1L, new Message(1, "Hello World", "sarath"));
			messages.put(2L, new Message(2, "Hello Jersey", "sarath"));
		}
		
     public List<Message> getAllMessages() {
			return new ArrayList<Message>(messages.values()); 
		}
     public Message getMessage(long id) throws Exception {
 		Message message = messages.get(id);
 		if (message == null) {
			throw new DataNotFoundException("Message with id " + id + " not found");
		
 		}
 		return message;
 	}
 	
 	public Message addMessage(Message message) {
 		message.setId(messages.size() + 1);
 		messages.put(message.getId(), message);
 		return message;
 	}
 	
 	public Message updateMessage(Message message) {
 		if (message.getId() <= 0) {
 			return null;
 		}
 		messages.put(message.getId(), message);
 		return message;
 	}
 	
 	public Message removeMessage(long id) {
 		return messages.remove(id);
 	}

 	

	
		
		
		
	}


