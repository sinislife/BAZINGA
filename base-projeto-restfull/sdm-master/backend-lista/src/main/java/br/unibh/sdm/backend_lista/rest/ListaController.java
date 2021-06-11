package br.unibh.sdm.backend_lista.rest;

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

import br.unibh.sdm.backend_lista.entidades.Lista;
import br.unibh.sdm.backend_lista.negocio.ListaService;

/**
 * Classe contendo as definições de serviços REST/JSON para Lista
 * @author jhcru
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "lista")
public class ListaController {
   
    private final ListaService listaService;

    public ListaController(ListaService listaService){
        this.listaService=listaService;
    }

    @GetMapping(value = "")
    public List<Lista> getListas(){
        return listaService.getListas();
    }
    
    @GetMapping(value="{cpf}")
    public Lista getListaByCpf(@PathVariable String cpf) throws Exception{
        if(!ObjectUtils.isEmpty(cpf)){
           return listaService.getListaById(cpf);
        }
        throw new Exception("Lista com cpf "+cpf+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Lista createLista(@RequestBody @NotNull Lista lista) throws Exception {
         return listaService.saveLista(lista);
    }
    
    @PutMapping(value = "{cpf}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Lista updateLista(@PathVariable String cpf, 
    		@RequestBody @NotNull Lista lista) throws Exception {
         return listaService.saveLista(lista);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{cpf}")
    public boolean updateLista(@PathVariable String cpf) throws Exception {
         listaService.deleteLista(cpf);
         return true;
    }
    
}