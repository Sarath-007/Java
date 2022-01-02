package org.sarath.restAPI.messenger2.messageresource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sarath.restAPI.messenger2.model.Message;
import org.sarath.restAPI.messenger2.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService ms=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return ms.getAllMessages();
		
		
	}
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long id,@Context UriInfo uriInfo) throws Exception {
		Message message= ms.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		
		
		return message;
		
	}
	
	// URI LIMK FOR SELF
		private String getUriForSelf(UriInfo uriInfo, Message message) {
			String uri = uriInfo.getBaseUriBuilder()
			 .path(MessageResource.class)
			 .path(Long.toString(message.getId()))
			 .build()
			 .toString();
			return uri;
		}
		// URI LINK FOR PROFILES

		private String getUriForProfile(UriInfo uriInfo, Message message) {
			URI uri = uriInfo.getBaseUriBuilder()
	       		 .path(ProfileResource.class)
	       		 .path(message.getAuthor())
	             .build();
	        return uri.toString();
		}
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// location  header and status code setting
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		
		Message newMessage = ms.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return ms.updateMessage(message);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		ms.removeMessage(id);
	}
	


}
