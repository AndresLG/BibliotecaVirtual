package interfaces;

import java.util.List;
import model.PrestamoDetalleM;

public interface PrestamoDetalleI {
    
    void guardar(PrestamoDetalleM prestamoDetalle) throws Exception;

    void modificar(PrestamoDetalleM prestamoDetalle) throws Exception;

    void eliminar(PrestamoDetalleM prestamoDetalle) throws Exception; // cambia de estado al detalle del prestamo por I 

    void activar(PrestamoDetalleM prestamoDetalle) throws Exception; // cambia de estado al detalle del prestamo por A 

    List<PrestamoDetalleM> listar() throws Exception;
}
