package inicio.microservicios_contacto_04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inicio.microservicios_contacto_04.dao.AgendaDao;
import inicio.microservicios_contacto_04.model.Contacto;

/*
 * como queremos que Spring instancie esta clase para que luego se inyecte donde se va a utilzar 
 * que seran los controladores se utiliza la anotacion @Service
 * -@Service es mas adecuada para una clase que contiene la logica de nogocio o logica como tal
 *  del microservicio

 * @Service:

 *Uso: Indica que la clase es un servicio. Se usa principalmente para las clases que contienen 
 *lógica de negocio. Spring gestiona estas clases como beans en el contenedor de Spring.

 *Ejemplo: Una clase que realiza cálculos, maneja transacciones o contiene la lógica principal de 
 *la aplicación.

 *Ventajas: Permite que Spring gestione transacciones y aspectos relacionados con la lógica de 
 *negocio.
 */
@Service
public class AgendaServiceImpl implements AgendaService {

    /*
     * como vamos a utilizar los objetos de la clase AgendaDao dentro de la capa de
     * servicios para
     * llamar a los metodos para que hagan las operaciones sobre la capa de
     * persistencia, hay que inyectar
     * una implementacion de AgendaDao
     * - declaramo la variable del tio de la interfaz en este caso es AgendaDao
     */
    @Autowired
    AgendaDao dao;

    @Override
    public Boolean agregarContacto(Contacto contacto) {

        if (dao.recuperarContacto(contacto.getIdContacto()) == null) {
            dao.agregarContacto(contacto);
            return true;
        }
        return false;
    }

    @Override
    public List<Contacto> recuperarContactos() {
        return dao.devolverContactos();
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        if (dao.recuperarContacto(contacto.getIdContacto()) != null) {
            dao.actualizarContacto(contacto);
        }
    }

    @Override
    public Boolean eliminarContacto(int idContacto) {
        if (dao.recuperarContacto(idContacto) != null) {
            dao.eliminarContacto(idContacto);
            return true;
        }
        return false;
    }

    @Override
    public Contacto buscarContacto(int idContacto) {
        return dao.recuperarContacto(idContacto);
    }

}
