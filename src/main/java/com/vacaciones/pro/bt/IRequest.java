package com.vacaciones.pro.bt;

import java.util.List;

import com.vacaciones.pro.dl.dto.RequestDTO;
import com.vacaciones.pro.dl.entities.Collaborator;

public interface IRequest {
	
	public RequestDTO addRequest(RequestDTO newRequest);
	
	public RequestDTO getRequestById(Long id);
	
	public List<RequestDTO> updateStatusRequest(RequestDTO newRequest);
	
	public List<RequestDTO> getRequestsByCollaboratorId(Long id);
	

}
