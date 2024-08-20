package inicio.microservicios_contacto_04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import inicio.microservicios_contacto_04.model.Contacto;
import inicio.microservicios_contacto_04.service.AgendaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/*
 * 1. recuperar contactos-mostrarcontactos
 * 2. buscar contactos por id
 * 3. guardar contacto
 * 4. actualizar contacto
 * 5. eliminar por id 
 */

@RestController
public class ContactosController {
    @Autowired
    AgendaService service;

    @GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> recuperarContactos(){
        return service.recuperarContactos();
    }

    @GetMapping(value = "contactos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contacto recuperarContacto (@PathVariable ("id")int id){
        return service.buacarContacto(id);
    }

    @PostMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String guardarContacto (@RequestBody Contacto contacto){
        return String.valueOf(service.agregarContacto(contacto));
    }

    @PutMapping(value = "contactos",consumes =  MediaType.APPLICATION_JSON_VALUE)
    public String actualizarContacto (@RequestBody Contacto contacto){
        service.actualizarContacto(contacto);
    }

    @DeleteMapping(value = "eliminarPorId/{id}")
    public void eliminarPorId (@PathVariable ("id")int idContacto){
        service.eliminarContacto(idContacto);
    }
}
