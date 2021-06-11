package br.unibh.sdm.backend_lista.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import br.unibh.sdm.backend_lista.entidades.Lista;
import br.unibh.sdm.backend_lista.persistencia.ListaRepository;


/**
 * Classe contendo a lógica de negócio para Cotação
 * @author sinislife
 *
 */
@Service
public class ListaService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final ListaRepository listaRepo;

    public ListaService(ListaRepository listaRepository){
        this.listaRepo=listaRepository;
    }
    
    public List<Lista> getListas(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Lista> lista = this.listaRepo.findAll();
        if (lista == null) {
        	return new ArrayList<Lista>();
        }
        return IteratorUtils.toList(lista.iterator());
    }    


    
    public List<Lista> getListaByCpf(String cpf){
    	if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Lista> lista = this.listaRepo.findByCpf(cpf);
        if (lista == null) {
        	return new ArrayList<Lista>();
        }
        return IteratorUtils.toList(lista.iterator());
    }
    
    public Lista saveLista(Lista lista){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Lista com os detalhes {}",lista.toString());
        }
        return this.listaRepo.save(lista);
    }
    
    public void deleteLista(String id){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Lista com id {}",id);
        }
        this.listaRepo.deleteById(id);
    }

    public boolean isListaExists(Lista lista){
    	Optional<Lista> retorno = this.listaRepo.findById(lista.getCpf());
        return retorno.isPresent() ? true:  false;
    }
    
    
    public Lista getListaById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Lista com o codigo {}",id);
        }
        Optional<Lista> retorno = this.listaRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Lista com o id "+id+" nao encontrada");
        }
        return retorno.get();
    }

}