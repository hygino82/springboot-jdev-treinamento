package com.cursojdev.aplicacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursojdev.aplicacao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findById(long id);

	//@Query("Select u from Usuario u Where upper(trim(u.nome)) like %?1%")
	public List<Usuario> findByNomeContainsIgnoreCase(String nome);
}
