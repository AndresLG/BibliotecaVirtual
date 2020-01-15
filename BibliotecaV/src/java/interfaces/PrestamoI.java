package interfaces;

import java.util.List;
import model.PrestamoM;

public interface PrestamoI {
    
    void guardar(PrestamoM prestamo) throws Exception;

    void modificar(PrestamoM prestamo) throws Exception;

    void eliminar(PrestamoM prestamo) throws Exception; // cambia de estado al prestamo por I 

    void desactivar(PrestamoM prestamo) throws Exception; // cambia de estado al prestamo por A 

    List<PrestamoM> listar() throws Exception;
}
