package com.vacaciones.pro.pl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vacaciones.pro.bt.ICollaborator;
import com.vacaciones.pro.bt.IUsuario;
import com.vacaciones.pro.dl.dto.CollaboratorDTO;
import com.vacaciones.pro.dl.dto.CollaboratorDTOGet;
import com.vacaciones.pro.dl.dto.UserDTOOut;

@Controller
public class IndexController {

	@Autowired
	ICollaborator colaboratorService;
	
	@Autowired
	IUsuario usuarioService;
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/solicitudes")
	public String solicitudes( HttpSession session , Model model ) {
		UserDTOOut usuario = (UserDTOOut) session.getAttribute("usuario");
		model.addAttribute("solicitudes",usuario.getRequest());
		return "solicitudes-admin";
	}
	
	@GetMapping(value = "/colaboradores")
	public String colaboradores( HttpSession session , Model model ) {
		List<CollaboratorDTOGet> colaboradores = colaboratorService.getAllCollaborators();
		model.addAttribute("colaboradores",colaboradores);
		return "colaboradores";
	}
	
	@GetMapping(value = "/usuarios")
	public String usuarios( Model model ) {
		List<UserDTOOut> usuarios = usuarioService.getAllUsers();
		model.addAttribute("usuarios",usuarios);
		return "usuarios";
	}
	
}
