package com.labhi.auth.model;

import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
	public class User {
	    @Id
	    private ObjectId id;
	    private String email;
	    private String password;
	    private String name;
	    private String lastName;
	    private Integer active=1;
	    private boolean isLoacked=false;
	    private boolean isExpired=false;
	    private boolean isEnabled=true;
	    private Set<Role> role;

	    public ObjectId getId() {
	        return id;
	    }

	    public void setId(ObjectId id) {
	        this.id = id;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public Integer getActive() {
	        return active;
	    }

	    public void setActive(Integer active) {
	        this.active = active;
	    }

	    public Set<Role> getRole() {
	        return role;
	    }

	    public void setRole(Set<Role> role) {
	        this.role = role;
	    }

	    public boolean isLoacked() {
	        return isLoacked;
	    }

	    public void setLoacked(boolean loacked) {
	        isLoacked = loacked;
	    }

	    public boolean isExpired() {
	        return isExpired;
	    }

	    public void setExpired(boolean expired) {
	        isExpired = expired;
	    }

	    public boolean isEnabled() {
	        return isEnabled;
	    }

	    public void setEnabled(boolean enabled) {
	        isEnabled = enabled;
	    }

}
