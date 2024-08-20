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
    /*
     * recuperar contactos es para mostar todos los contactos que hay en la base de datos
     * //!la clase es tipo list porque va a retornar toda la lista de contactos para poder mostrarla
     * lo que retorna se guarda en la variable service 
     */
    @GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> recuperarContactos(){
        return service.recuperarContactos();
    }
    /*
     * en esta solicitud http vamos a mostrar el contacto que se indique con el id
     * el produces = MediaType.APPLICATION_JSON_VALUE indica que voy a retornar un dato tipo json
     * //!este metodo retorna un tipo Contacto porque va a retornar uno solo, en formato Contacto.
     * se utiliza patch variable para mapear una variable en  el url en este aso seria una variable
     * tipo int llamada id que se encontrara en el patron de la url como id
     * //?retornará en la variable service un cuerpo json cuando se encuentre el contacto por el id
     * //?que se ha especificado y se debe colocar parametro que sera la variable.
     * .buscarContacto se utiliza porque este ya tiene una programacion previa en service donde 
     * especifica que hace el metodo buscarContacto.
     */
    @GetMapping(value = "contactos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contacto recuperarContacto (@PathVariable ("id")int id){
        return service.buscarContacto(id);
    }

    @PostMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String guardarContacto (@RequestBody Contacto contacto){
        return String.valueOf(service.agregarContacto(contacto));
    }

    @PutMapping(value = "contactos",consumes =  MediaType.APPLICATION_JSON_VALUE)
    public void actualizarContacto(@RequestBody Contacto contacto){
        service.actualizarContacto(contacto);
    }

    @DeleteMapping(value = "eliminarPorId/{id}")
    public void eliminarPorId (@PathVariable ("id")int idContacto){
        service.eliminarContacto(idContacto);
    }
}
