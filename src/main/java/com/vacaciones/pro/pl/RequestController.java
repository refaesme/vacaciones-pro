package com.vacaciones.pro.pl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.pro.bt.IRequest;
import com.vacaciones.pro.bt.IUsuario;
import com.vacaciones.pro.dl.dto.RequestDTO;
import com.vacaciones.pro.dl.dto.UserDTOOut;
@CrossOrigin
@RestController
public class RequestController {
	
	@Autowired
	private IRequest requestService;
	

	
	@PostMapping(value = "/requests")
	public String addRequest(@RequestBody RequestDTO requestDTO) {
		
		requestService.addRequest(requestDTO);
		return "redirect:/solicitudes-user";
	}
	
	@RequestMapping(value = "/requests", method = RequestMethod.PUT)
	public String updateRequest(@RequestBody RequestDTO requestDTO, Model model) {
		List<RequestDTO> solicitudes = requestService.updateStatusRequest(requestDTO);
		model.addAttribute("solicitudes", solicitudes);
		return "redirect:/solicitudes-admin"; 
	}
	
	@GetMapping(value = "/requests/{id}")
	public List<RequestDTO> getSolicitudesByIdCollaborator(@PathVariable Long id){
		return requestService.getRequestsByCollaboratorId(id);
		
	}

}
