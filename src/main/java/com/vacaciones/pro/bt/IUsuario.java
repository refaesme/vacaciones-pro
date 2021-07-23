package com.vacaciones.pro.bt;

import java.util.List;

import com.vacaciones.pro.dl.dto.UserDTOIn;
import com.vacaciones.pro.dl.dto.UserDTOOut;

public interface IUsuario {

	public void addUser(UserDTOIn user, Long idCollaborator);
	
	public UserDTOOut loginUser(String userName , String UserPass);
	
	public UserDTOOut getUserById(Long id);
	
	public List<UserDTOOut> getAllUsers();
}
