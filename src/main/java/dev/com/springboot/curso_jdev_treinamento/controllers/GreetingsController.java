package dev.com.springboot.curso_jdev_treinamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.com.springboot.curso_jdev_treinamento.model.Usuario;
import dev.com.springboot.curso_jdev_treinamento.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class GreetingsController {
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.salvarUsuario(usuario);
	}

	@RequestMapping(value = "mostrarnome/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Curso Spring Boot API: " + name + "!";
	}

	@GetMapping("/olamundo/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public String metodoRetornaOlaMundo(@PathVariable String nome) {
		return "Olá mundo : " + nome;
	}
}
