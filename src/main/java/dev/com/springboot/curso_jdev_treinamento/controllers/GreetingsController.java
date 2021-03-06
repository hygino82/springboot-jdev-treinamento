package dev.com.springboot.curso_jdev_treinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.com.springboot.curso_jdev_treinamento.model.Usuario;
import dev.com.springboot.curso_jdev_treinamento.service.UsuarioService;

@RestController
@RequestMapping
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

	@GetMapping(value = "buscarporid")
	@ResponseBody
	public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam(name = "id") Long id) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> deletarUsuario(@RequestParam long iduser) {
		usuarioService.deletarUsuario(iduser);

		return new ResponseEntity<String>("Usuário deletado com sucesso", HttpStatus.OK);
	}

	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizarUsuarioPorId(@RequestBody Usuario usuario) {

		if (usuario.getId() == null) {
			return new ResponseEntity<String>("Id não informado para a atualização do usuário.",
					HttpStatus.BAD_REQUEST);
		}

		Usuario user = usuarioService.atualizarUsuarioPorId(usuario);

		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}

	@GetMapping(value = "nome")
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarUsuarioPorNome(@RequestParam(name = "nome") String nome) {
		List<Usuario> usuarios = usuarioService.buscarUsuarioPorNome(nome.trim());

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
}
