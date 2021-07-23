package com.vacaciones.pro.pl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.pro.bt.ICollaborator;
import com.vacaciones.pro.dl.dto.CollaboratorDTO;
@CrossOrigin
@RestController
public class CollaboratorController {

	@Autowired
	private ICollaborator collaboratorService;
	
	
	@PostMapping("/collaborators")
	public void addCollaborator(@RequestBody CollaboratorDTO collaborator) {
		
		collaboratorService.addCollaborator(collaborator);
		
	}
}
