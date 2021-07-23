package com.vacaciones.pro.dl.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vacaciones.pro.dl.entities.Request;

public class UserDTOOut {
	
	private Long id;
	private Long rolId;
	private String userName;
	private Long rutCollaborator;
	private List<RequestDTO> request;
	
	public UserDTOOut() {
		request = new ArrayList<>();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRolId() {
		return rolId;
	}
	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}
	public List<RequestDTO> getRequest() {
		return request;
	}
	public void setRequest(List<RequestDTO> request) {
		this.request = request;
	}

	public Long getRutCollaborator() {
		return rutCollaborator;
	}

	public void setRutCollaborator(Long rutCollaborator) {
		this.rutCollaborator = rutCollaborator;
	}
	
	
	

}
