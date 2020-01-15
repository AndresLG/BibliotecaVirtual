package interfaces;

import java.util.List;
import model.PersonaM;

public interface IPersona {

    void guardar(PersonaM persona) throws Exception;

    void modificar(PersonaM persona) throws Exception;

    void eliminar(PersonaM persona) throws Exception; // cambia de estado a la evaluación por I 

    void activar(PersonaM persona) throws Exception; // cambia de estado a la evaluación por A 

    List<PersonaM> listar() throws Exception;
    
    PersonaM iniciarSesion(String User, String Pass) throws Exception;
}
