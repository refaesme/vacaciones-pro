package com.vacaciones.pro.bt;

import java.util.List;

import com.vacaciones.pro.dl.dto.CollaboratorDTO;
import com.vacaciones.pro.dl.dto.CollaboratorDTOGet;

public interface ICollaborator {
	
	public void addCollaborator(CollaboratorDTO newColaborator);
	
	public CollaboratorDTO getCollaboratorById(Long id);
	
	public List<CollaboratorDTOGet> getAllCollaborators();
	
	

}
