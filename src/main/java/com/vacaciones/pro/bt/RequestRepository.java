package com.vacaciones.pro.bt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.pro.dl.entities.Collaborator;
import com.vacaciones.pro.dl.entities.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{
	
	public List<Request> findByCollaboratorId(Long collaboratorId);
	

}
