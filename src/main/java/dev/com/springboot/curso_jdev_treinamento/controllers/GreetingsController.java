package dev.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.com.springboot.curso_jdev_treinamento.model.Usuario;
import dev.com.springboot.curso_jdev_treinamento.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class GreetingsController {
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
		Usuario user = usuarioService.salvarUsuario(usuario);

		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}

	@GetMapping(value = "listatodos")
	@ResponseBody // retorna o corpo da resposta
	public ResponseEntity<List<Usuario>> listaUsuario() {
		List<Usuario> usuarios = usuarioService.listaUsuario();

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@GetMapping(value = "{id}")
	@ResponseBody
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable long id) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> deletarUsuario(@RequestParam long iduser) {
		usuarioService.deletarUsuario(iduser);

		return new ResponseEntity<String>("Usuário deletado com sucesso", HttpStatus.OK);
	}

//	@PutMapping(value = "{id}")
//	@ResponseBody
//	public ResponseEntity<Usuario> atualizarUsuarioPorId(@PathVariable long id,@RequestBody Usuario usuario){
//		
//	}
}
