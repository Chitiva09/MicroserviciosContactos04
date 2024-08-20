package inicio.microservicios_contacto_04.service;

import java.util.List;

import inicio.microservicios_contacto_04.model.Contacto;

public interface AgendaService {

Boolean agregarContacto (Contacto contacto);
/*
da la posibilidad de agregar contacto desde un objeto contacto pero con el boolean nos informa si
se ha podido añadir o no, en caso de que ya exista no lo añade y devuelve falso y si se pudo añadir
devolvera verdadero
*Este método acepta un objeto de tipo Contacto como parámetro.
 */
List<Contacto> recuperarContactos();
/*
 * recuperarcontactos devuelve toda la lista de contactos por eso el return es un list
 *  de la identidad contacto
 */
void actualizarContacto(Contacto contacto);
/*
 * no retorna nada, solo se ejecuta y ya, actualza contacto desde un objeto contacto
 */
Boolean eliminarContacto( int idContacto);
/*
 * elimina contacto con el idContacto, con el boolean nos da falso si no se ha podido eliminar
 *  el contacto y verdadero cuando se ha podido eliminar el contacto con exito
 */
Contacto buscarContacto(int idContacto);
/*
 * busca contactos por la idContacto, retorna Contacto, porque al buscar por idContacto traera el 
 * objeto contacto con todas sus propiedades 
 * CHATGPT: Retorna un objeto Contacto con la información del contacto correspondiente al idContacto.
 * Si no se encuentra el contacto, el retorno podría ser null
 *  (aunque esto no está especificado en la interfaz). 
 */
}
