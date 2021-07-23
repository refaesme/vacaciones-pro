package com.vacaciones.pro.pl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.ui.Model;

import com.vacaciones.pro.bt.IUsuario;
import com.vacaciones.pro.dl.dto.UserDTOIn;
import com.vacaciones.pro.dl.dto.UserDTOOut;
@CrossOrigin
@Controller
public class UserController {
	
	@Autowired
	IUsuario usuarioService;

	@PostMapping(value = "/users/{id}")
	public String addUser(@RequestBody UserDTOIn newUser,@PathVariable Long id) {
		usuarioService.addUser(newUser, id);
		return "usuarios";
	}
	
	@GetMapping(value = "/users")
	public String login(@RequestParam String user,@RequestParam String pass, Model model, HttpSession session)throws ResponseStatusException {
		UserDTOOut userDTOOut = usuarioService.loginUser(user, pass);
		session.setAttribute("usuario", userDTOOut);
		if(userDTOOut == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe usuario");
		}
		model.addAttribute("user", userDTOOut);
		model.addAttribute("solicitudes", userDTOOut.getRequest());
		
		return userDTOOut.getRolId() == 1 ? "solicitudes-admin" : "solicitudes-user";
	}
	
}
