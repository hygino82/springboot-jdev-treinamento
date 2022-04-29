package dev.com.springboot.curso_jdev_treinamento.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */
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
