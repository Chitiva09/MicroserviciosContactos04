package inicio.microservicios_contacto_04.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import inicio.microservicios_contacto_04.model.Contacto;
/*
JpaRepository no es una clase, es una interfaz de springdataJPA que ofrece todos los metodos CRUD
mas la posibilidad de definir nuestros propios metodos para que luego sean implementaados por spring
*/
public interface AgendaJpaSpring extends JpaRepository<Contacto, Integer>{
    /*
    se indica el tipo de identidad con la que trabajamos "Conacto", y el tipo de la primay key "Integer"*/
    Contacto findByEmail(String email);
    /*
    El nombre del método sigue una convención de nomenclatura
    de Spring Data JPA. findBy indica que el método debe buscar entidades basadas en el valor
    de un campo. En este caso, busca por el campo email.*/ 
    @Transactional
    /*
    todo lo que son operaciones jpa deben estar dentro de un contexto transaccional, 
    Marca el método para que sea ejecutado en una transacción, lo que garantiza que todas las 
    operaciones dentro del método se completen correctamente o ninguna se aplique en caso de error. En
    este contexto, asegura que la operación de modificación se realice de forma segura.*/
    @Modifying
    /*
    Se usa en combinación con @Query para señalar que el método no es solo una consulta
    de lectura, sino que modificará la base de datos (en este caso, para eliminar datos). */
    @Query("Delete from Contacto c Where c.email=?1 ")
    /*
    Esta es una consulta JPQL (Java Persistence Query Language) personalizada que especifica la
    operación a realizar.*/
    void eliminarPorEmail(String email);
}
