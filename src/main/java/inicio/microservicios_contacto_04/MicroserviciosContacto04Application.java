package inicio.microservicios_contacto_04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 *este es uno de los ultimmos pasos para la creacon del mcroservicio.

 * estas anotaciones son utilizdas para indicarle a SpringBoot en que carpeta o package debe buscar 
 * o escanear para poder encontrar las cosas que necesita.
 */

/*
 * @CompoentScan se utiliza para decirle a spring en que carpetas o pakage estan ubicadas las 
 * clases las cuales puede instanciar, identificadas con @Service, @Restcontroller, @Repository
 */
@ComponentScan(basePackages = {"controller", "dao", "service"})

/*
 * La anotación @EntityScan en Spring Boot se utiliza para especificar los paquetes en los que 
 * Spring debe buscar clases anotadas con @Entity. Estas clases representan entidades 
 * JPA (Java Persistence API) que se mapean a tablas en una base de datos.
 */
@EntityScan(basePackages= {"model"})

/*
 * La anotación @EnableJpaRepositories en Spring Boot se utiliza para habilitar la creación y 
 * configuración automática de repositorios JPA. Esta anotación le indica a Spring en qué paquetes 
 * buscar las interfaces de repositorio que extienden JpaRepository u otras interfaces de Spring 
 * Data JPA.
 */
@EnableJpaRepositories(basePackages = {"dao"})

@SpringBootApplication
public class MicroserviciosContacto04Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosContacto04Application.class, args);
	}

}
