package com.cursojdev.aplicacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cursojdev.aplicacao.model.Usuario;

@Service
public interface UsuarioService {

	Usuario salvarUsuario(Usuario usuario);

	List<Usuario> listaUsuario();

	Usuario buscarUsuarioPorId(long id);

	void deletarUsuario(long iduser);

	Usuario atualizarUsuarioPorId(Usuario usuario);

	List<Usuario> buscarUsuarioPorNome(String nome);
}
