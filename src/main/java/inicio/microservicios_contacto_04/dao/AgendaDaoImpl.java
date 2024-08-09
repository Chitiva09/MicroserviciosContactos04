package inicio.microservicios_contacto_04.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import inicio.microservicios_contacto_04.model.Contacto;

@Repository
public class AgendaDaoImpl implements AgendaDao{

    @Autowired
    /*
     * es parte del framework Spring y se usa para la inyección de dependencias. Esto significa que
     *  Spring se encargará de proporcionar una instancia de la clase necesaria 
     * (en este caso, AgendaJpaSpring) al campo o al constructor anotado.
     */
    AgendaJpaSpring agenda;

    @Override
    public void agregarContacto(Contacto contacto) {
        agenda.save(contacto);
    }

    @Override
    public Contacto recuperContacto(String email) {
        return agenda.findByEmail(email);
    }

    @Override
    public void eliminarContacto(String email) {
        agenda.eliminarPorEmail(email);
    }

    @Override
    public List<Contacto> devolverContactos() {
        return agenda.findAll();
    }

    @Override
    public void eliminarContacto(int idContacto) {
        agenda.deleteById(idContacto);
    }

    @Override
    public Contacto recuperarContacto(int idContacto) {
        return agenda.findById(idContacto).orElse(null);
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        agenda.save(contacto);
    }

}
