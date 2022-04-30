package com.cursojdev.aplicacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojdev.aplicacao.model.Usuario;
import com.cursojdev.aplicacao.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarUsuarioPorId(long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public void deletarUsuario(long iduser) {
		Usuario usuario = usuarioRepository.findById(iduser);
		usuarioRepository.delete(usuario);
	}

	@Override
	public Usuario atualizarUsuarioPorId(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

	@Override
	public List<Usuario> buscarUsuarioPorNome(String nome) {
		List<Usuario> usuarios = usuarioRepository.findByNomeContainsIgnoreCase(nome);

		return usuarios;
	}

}
