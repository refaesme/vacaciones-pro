package com.vacaciones.pro.bt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.pro.dl.entities.Collaborator;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long>{

}
