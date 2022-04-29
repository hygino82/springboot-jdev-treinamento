package dev.com.springboot.curso_jdev_treinamento.service;

import org.springframework.stereotype.Service;

import dev.com.springboot.curso_jdev_treinamento.model.Usuario;

@Service
public interface UsuarioService {

	Usuario salvarUsuario(Usuario usuario);

}
