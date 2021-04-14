package br.unibh.sdm.backend_usuario.rest;

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

import br.unibh.sdm.backend_usuario.entidades.Usuario;
import br.unibh.sdm.backend_usuario.negocio.UsuarioService;

/**
 * Classe contendo as definições de serviços REST/JSON para Usuario
 * @author jhcru
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "usuario")
public class UsuarioController {
   
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @GetMapping(value = "")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }
    
    @GetMapping(value="{cpf}")
    public Usuario getUsuarioByCpf(@PathVariable String cpf) throws Exception{
        if(!ObjectUtils.isEmpty(cpf)){
           return usuarioService.getUsuarioById(cpf);
        }
        throw new Exception("Usuario com cpf "+cpf+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario createUsuario(@RequestBody @NotNull Usuario usuario) throws Exception {
         return usuarioService.saveUsuario(usuario);
    }
    
    @PutMapping(value = "{cpf}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario updateUsuario(@PathVariable String cpf, 
    		@RequestBody @NotNull Usuario usuario) throws Exception {
         return usuarioService.saveUsuario(usuario);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{cpf}")
    public boolean updateUsuario(@PathVariable String cpf) throws Exception {
         usuarioService.deleteUsuario(cpf);
         return true;
    }
    
}