package inicio.microservicios_contacto_04.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity//indica que esta clase es una entidad, y que esta clase representa una tabla en la base de datos
@Table(name= "contactos")//con esta anotacion hago referencia a la tabla que voy a manejar en la base de datos
@NamedQuery(name="contacto.findAll", query = "SELECT c FROM Contacto c" ) //pra este ejemplo no es 
//tan necesaria pero se deja ahi, se utiliza como comunicacion con la base de datos, lo que dice 
//tambien es que cuando se llame al metodo findAll de la clase Contacto, ejecutara el SQL que hay ahi...


public class Contacto implements Serializable {

    @Id//Se usa para marcar el campo que representa la clave primaria de la entidad.
    @GeneratedValue( strategy= GenerationType.IDENTITY )// este lo utilizo porque da a entender que la primary key esta en una constante de crecimiento (un consecutivo)
    private int idContacto;
    private int edad;
    private String email;
    private String nombre;
    /*
     * Necesidad para JPA/Hibernate: En Java, los frameworks de persistencia como JPA (Java
     * Persistence API) o Hibernate requieren un constructor vacío o sin parámetros para poder
     * instanciar objetos de la clase cuando están recuperando datos de la base de datos. Esto se 
     * debe a que estos frameworks suelen utilizar técnicas de reflexión para crear instancias de 
     * entidades antes de poblar sus campos con los datos recuperados.
     * 
     * Flexibilidad: Tener un constructor vacío permite que otros desarrolladores o partes del 
     * código puedan crear una instancia de la clase sin necesidad de proporcionar todos los 
     * atributos al momento de la creación. Esto es útil en situaciones donde los datos se 
     * establecerán más adelante a través de los métodos set.

     *Compatibilidad con JavaBeans: La convención de los JavaBeans en Java requiere que haya un 
     *constructor sin argumentos para que las herramientas y frameworks puedan trabajar con la 
     *clase sin problemas. Esto es importante en aplicaciones que utilizan tecnologías que dependen 
     *de la introspección de las clases (como JSP, JSF, o Spring).
     */
    public Contacto(){

    }

    public int getIdContacto() {
        return idContacto;
    }
    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
