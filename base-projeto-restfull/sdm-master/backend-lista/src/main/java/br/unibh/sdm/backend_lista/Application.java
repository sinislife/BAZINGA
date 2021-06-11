package br.unibh.sdm.backend_lista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import br.unibh.sdm.backend_lista.persistencia.DynamoDBConfig;

/**
 * Classe executável que inicia a aplicação Spring Boot
 * @author sinislife
 *
 */
@SpringBootApplication
@Import({DynamoDBConfig.class})
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	
	public static void main(String[] args) {
		log.info("Inicializando...");
	    System.setProperty("server.servlet.context-path", "/lista-api");
		new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
	}
	
}
