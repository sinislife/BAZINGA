package br.unibh.sdm.backend_blog.persistencia;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_blog.entidades.Blog;

/**
 * Esta classe estende o padrão CrudRepository 
 * @author jhcru
 *
 */
@EnableScan()
public interface BlogRepository extends CrudRepository<Blog, String> {
	
	List<Blog> findByCpf(String cpf);
	
}
