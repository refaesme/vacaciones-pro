package com.vacaciones.pro.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.pro.bt.CollaboratorRepository;
import com.vacaciones.pro.bt.ICollaborator;
import com.vacaciones.pro.bt.UserRepository;
import com.vacaciones.pro.dl.entities.Collaborator;
import com.vacaciones.pro.dl.dto.CollaboratorDTO;
import com.vacaciones.pro.dl.dto.CollaboratorDTOGet;

@Service
public class CollaboratorImpl implements ICollaborator {

	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public void addCollaborator(CollaboratorDTO newColaborator) {
	
		collaboratorRepository.save(mapCollaborator(newColaborator));
	}

	@Override
	public CollaboratorDTOGet getCollaboratorById(Long id) {
		Collaborator collaborator = collaboratorRepository.getById(id);
		CollaboratorDTOGet col = new CollaboratorDTOGet();
		col.setEmail(collaborator.getCollaboratorEmail());
		col.setId(collaborator.getCollaboratorId());
		col.setName(collaborator.getCollaboratorSurname());
		col.setSurName(collaborator.getCollaboratorSurname());
		return col;
	}

	@Override
	public List<CollaboratorDTOGet> getAllCollaborators() {
		List<CollaboratorDTOGet> collaboratorsGet  = new ArrayList<CollaboratorDTOGet>();
		collaboratorRepository.findAll().stream().forEach(collaboratorEntity ->{
			collaboratorsGet.add(mapCollaboratorGet(collaboratorEntity));
		});
		return collaboratorsGet;
	}

	private Collaborator mapCollaborator(CollaboratorDTO collaboratorDTO) {
		
		Collaborator collaborator = new Collaborator();
		collaborator.setCollaboratorId(collaboratorDTO.getRut());
		collaborator.setCollaboratorName(collaboratorDTO.getName());
		collaborator.setCollaboratorSurname(collaboratorDTO.getSurName());
		collaborator.setCollaboratorEmail(collaboratorDTO.getEmail());
		return collaborator;
		
	}
	
	private CollaboratorDTOGet mapCollaboratorGet(Collaborator collaborator) {
		
		CollaboratorDTOGet collaboratorGet = new CollaboratorDTOGet(); 
		collaboratorGet.setId(collaborator.getCollaboratorId());
		collaboratorGet.setName(collaborator.getCollaboratorName());
		collaboratorGet.setSurName(collaborator.getCollaboratorSurname());
		collaboratorGet.setEmail(collaborator.getCollaboratorEmail());
		return collaboratorGet;
		
	}
}
