package org.sarath.restAPI.messenger2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.sarath.restAPI.messenger2.database.DatabaseClass;
import org.sarath.restAPI.messenger2.model.ErrorMessage;
import org.sarath.restAPI.messenger2.model.Profile;

public class ProfileService {
	
private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("koushik", new Profile(1L, "sarath", "sarath", "s"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		if(profileName==null) {
			 {
		 ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "http://javabrains.koushik.org");
				Response response = Response.status(Status.NOT_FOUND)
							.entity(errorMessage)
							.build();
				throw new NotFoundException(response);
			}
		}
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
