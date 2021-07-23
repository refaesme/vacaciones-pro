package com.vacaciones.pro.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.pro.bt.CollaboratorRepository;
import com.vacaciones.pro.bt.IRequest;
import com.vacaciones.pro.bt.RequestRepository;
import com.vacaciones.pro.dl.dto.RequestDTO;
import com.vacaciones.pro.dl.entities.Collaborator;
import com.vacaciones.pro.dl.entities.Request;

@Service
public class RequestImpl implements IRequest{

	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	@Override
	public RequestDTO addRequest(RequestDTO newRequest) {
		return mapRquestDTO(requestRepository.save(mapRquestDTO(newRequest)));
	}

	@Override
	public List<RequestDTO> updateStatusRequest(RequestDTO newRequest) {
		List<RequestDTO> requests = new ArrayList<>();
		Request request = requestRepository.findById(newRequest.getId()).orElse(null);
		if(request != null) {
			request.setRequestStatus(newRequest.getRequestStatus());
		}else {
			//log ocurrion un error para el id bla bla
		}
		
		requestRepository.save(request);
		
		requestRepository.findByCollaboratorId(request.getCollaboratorId()).forEach(element -> {
			requests.add(mapRquestDTO(element));
		});
		return requests;
	}
	
	private Request mapRquestDTO(RequestDTO requestDTO) {
		
		Request newRequest = null;
		Collaborator collaborator = collaboratorRepository.findById(requestDTO.getIdCollaborator()).orElse(null);
		if(collaborator != null) {
			newRequest = new Request();
			newRequest.setCollaborator(collaborator);
			newRequest.setCollaboratorId(collaborator.getCollaboratorId());
			newRequest.setRequestBeginDay(requestDTO.getRequestDayBegin());
			newRequest.setRequestEndDay(requestDTO.getRequestDayEnd());
			newRequest.setRequestCreatedAt(new Date());
			newRequest.setRequestStatus("PENDIENTE");
		}
		
		return newRequest;
		
		
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
	public List<RequestDTO> getRequestsByCollaboratorId(Long id) {
		List<RequestDTO> requests = new ArrayList<>();
		requestRepository.findByCollaboratorId(id).forEach(element -> {
			requests.add(mapRquestDTO(element));
		});
		return requests;
	}

	@Override
	public RequestDTO getRequestById(Long id) {
		return  mapRquestDTO(requestRepository.findById(id).orElse(null));
	}

	

	

	

}
