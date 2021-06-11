package br.unibh.sdm.backend_lista.persistencia;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_lista.entidades.Lista;

/**
 * Esta classe estende o padrão CrudRepository 
 * @author sinislife
 *
 */
@EnableScan()
public interface ListaRepository extends CrudRepository<Lista, String> {
	
	List<Lista> findByCpf(String cpf);
	
}
