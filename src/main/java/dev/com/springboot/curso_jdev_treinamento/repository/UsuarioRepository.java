package dev.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.com.springboot.curso_jdev_treinamento.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findById(long id);

	//@Query("Select u from Usuario u Where upper(trim(u.nome)) like %?1%")
	public List<Usuario> findByNomeContainsIgnoreCase(String nome);
}
