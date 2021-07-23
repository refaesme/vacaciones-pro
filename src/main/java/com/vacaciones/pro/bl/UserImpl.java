package com.vacaciones.pro.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.pro.bt.CollaboratorRepository;
import com.vacaciones.pro.bt.IUsuario;
import com.vacaciones.pro.bt.RequestRepository;
import com.vacaciones.pro.bt.UserRepository;
import com.vacaciones.pro.dl.dto.RequestDTO;
import com.vacaciones.pro.dl.dto.UserDTOIn;
import com.vacaciones.pro.dl.dto.UserDTOOut;
import com.vacaciones.pro.dl.entities.Collaborator;
import com.vacaciones.pro.dl.entities.Request;
import com.vacaciones.pro.dl.entities.User;

@Service
public class UserImpl implements IUsuario{

	private static final Long ADMINISTRADOR = 1L;

	@Autowired
	CollaboratorRepository collaboradorRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RequestRepository reqRepository;
	
	@Override
	public void addUser(UserDTOIn user, Long idCollaborator) {
		
		Collaborator collaborator =  collaboradorRepository.findById(idCollaborator).orElse(null);
		if(collaborator != null) {
			User newUser = new User();
			newUser.setUserName(user.getUserName());
			newUser.setUserPass(user.getPassWord());
			newUser.setCollaborator(collaborator);
			newUser.setUserState(true);
			newUser.setRolId(user.getRolId());
			userRepository.save(newUser);
		}
		
	}

	@Override
	public UserDTOOut loginUser(String userName, String UserPass) {
		
		User user = userRepository.findByUserNameAndUserPass(userName, UserPass);
		List<RequestDTO> requests = null;
		
		if(user.getRolId() == ADMINISTRADOR) {
			requests = agregaTodasLasSolicitudes();
		}else {
			requests = agregaSolicitudesSoloparaElUsuario(user);
		}
		
		UserDTOOut userDTOOut = null;
		if(user != null) {
			userDTOOut = new UserDTOOut();
			userDTOOut.setRequest(requests);
			userDTOOut.setId(user.getUserId());
			userDTOOut.setRolId(user.getRolId());
			userDTOOut.setUserName(user.getUserName());
			userDTOOut.setRutCollaborator(user.getCollaborator().getCollaboratorId());
		}
		return userDTOOut;
	}
	
	private List<RequestDTO> agregaTodasLasSolicitudes() {
		List<RequestDTO> requests = new ArrayList<>();
		reqRepository.findAll().stream().forEach(elemento -> {
			requests.add(mapRquestDTO(elemento)); 
		});
		return requests;
	}

	private List<RequestDTO> agregaSolicitudesSoloparaElUsuario(User user) {
		List<RequestDTO> requests = new ArrayList<>();
		reqRepository.findByCollaboratorId(user.getCollaborator().getCollaboratorId()).stream().forEach(elemento -> {
			requests.add(mapRquestDTO(elemento)); 
		});
		return requests;
	}

	private RequestDTO mapRquestDTO(Request request) {
		
		RequestDTO requestDTO = new RequestDTO();
		requestDTO.setId(request.getRequestId());
		requestDTO.setIdCollaborator(request.getCollaboratorId());
		requestDTO.setRequestDayBegin(request.getRequestBeginDay());
		requestDTO.setRequestDayEnd(request.getRequestEndDay());
		requestDTO.setCreateAt(request.getRequestCreatedAt());
		requestDTO.setRequestStatus(request.getRequestStatus());
		return requestDTO;
		
		
	}

	@Override
	public UserDTOOut getUserById(Long id) {
		User user = userRepository.getById(id);
		UserDTOOut userDTOOut = null;
		if(user != null) {
			userDTOOut = new UserDTOOut();
			userDTOOut.setRequest(agregaSolicitudesSoloparaElUsuario(user));
			userDTOOut.setId(user.getUserId());
			userDTOOut.setRolId(user.getRolId());
			userDTOOut.setUserName(user.getUserName());
		}
		return userDTOOut;
	}

	@Override
	public List<UserDTOOut> getAllUsers() {
		List<UserDTOOut> usuarios = new ArrayList<UserDTOOut>();
		userRepository.findAll().forEach(elemento -> {
			UserDTOOut userDTOOut = new UserDTOOut();
			userDTOOut.setId(elemento.getUserId());
			userDTOOut.setRolId(elemento.getRolId());
			userDTOOut.setUserName(elemento.getUserName());
			userDTOOut.setRutCollaborator(elemento.getCollaborator().getCollaboratorId());
			usuarios.add(userDTOOut);
		});
		
		
		return usuarios;
	}

}
