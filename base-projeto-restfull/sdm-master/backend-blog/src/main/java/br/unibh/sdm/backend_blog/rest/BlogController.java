package br.unibh.sdm.backend_blog.rest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.sdm.backend_blog.entidades.Blog;
import br.unibh.sdm.backend_blog.negocio.BlogService;

/**
 * Classe contendo as definições de serviços REST/JSON para Blog
 * @author jhcru
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "blog")
public class BlogController {
   
    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService=blogService;
    }

    @GetMapping(value = "")
    public List<Blog> getBlogs(){
        return blogService.getBlogs();
    }
    
    @GetMapping(value="{cpf}")
    public Blog getBlogByCpf(@PathVariable String cpf) throws Exception{
        if(!ObjectUtils.isEmpty(cpf)){
           return blogService.getBlogById(cpf);
        }
        throw new Exception("Blog com cpf "+cpf+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Blog createBlog(@RequestBody @NotNull Blog blog) throws Exception {
         return blogService.saveBlog(blog);
    }
    
    @PutMapping(value = "{cpf}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Blog updateBlog(@PathVariable String cpf, 
    		@RequestBody @NotNull Blog blog) throws Exception {
         return blogService.saveBlog(blog);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{cpf}")
    public boolean updateBlog(@PathVariable String cpf) throws Exception {
         blogService.deleteBlog(cpf);
         return true;
    }
    
}