package dev.com.springboot.curso_jdev_treinamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.com.springboot.curso_jdev_treinamento.model.Usuario;

@Service
public interface UsuarioService {

	Usuario salvarUsuario(Usuario usuario);

	List<Usuario> listaUsuario();

	Usuario buscarUsuarioPorId(long id);

}
