package dev.com.springboot.curso_jdev_treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.com.springboot.curso_jdev_treinamento.model.Usuario;
import dev.com.springboot.curso_jdev_treinamento.repository.UsuarioRepository;

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

}
