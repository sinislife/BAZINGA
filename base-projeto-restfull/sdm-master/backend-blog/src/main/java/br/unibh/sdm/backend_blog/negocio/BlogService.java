package br.unibh.sdm.backend_blog.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.unibh.sdm.backend_blog.entidades.Blog;
import br.unibh.sdm.backend_blog.persistencia.BlogRepository;



/**
 * Classe contendo a lógica de negócio para Cotação
 * @author jhcru
 *
 */
@Service
public class BlogService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final BlogRepository blogRepo;

    public BlogService(BlogRepository blogRepository){
        this.blogRepo=blogRepository;
    }
    
    public List<Blog> getBlogs(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Blog> blog = this.blogRepo.findAll();
        if (blog == null) {
        	return new ArrayList<Blog>();
        }
        return IteratorUtils.toList(blog.iterator());
    }    


    
    public List<Blog> getBlogByCpf(String cpf){
    	if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Blog> blog = this.blogRepo.findByCpf(cpf);
        if (blog == null) {
        	return new ArrayList<Blog>();
        }
        return IteratorUtils.toList(blog.iterator());
    }
    
    public Blog saveBlog(Blog blog){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Blog com os detalhes {}",blog.toString());
        }
        return this.blogRepo.save(blog);
    }
    
    public void deleteBlog(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Blog com id {}",id);
        }
        this.blogRepo.deleteById(id);
    }

    public boolean isBlogExists(Blog blog){
    	Optional<Blog> retorno = this.blogRepo.findById(blog.getCpf());
        return retorno.isPresent() ? true:  false;
    }
    
    
    public Blog getBlogById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Blog com o codigo {}",id);
        }
        Optional<Blog> retorno = this.blogRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Blog com o id "+id+" nao encontrada");
        }
        return retorno.get();
    }

}