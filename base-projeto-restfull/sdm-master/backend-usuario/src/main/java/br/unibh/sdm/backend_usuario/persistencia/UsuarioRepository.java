package br.unibh.sdm.backend_usuario.persistencia;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_usuario.entidades.Usuario;

/**
 * Esta classe estende o padrão CrudRepository 
 * @author jhcru
 *
 */
@EnableScan()
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	List<Usuario> findByCpf(String cpf);
	
}
