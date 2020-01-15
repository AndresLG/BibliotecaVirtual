package interfaces;

import java.util.List;
import model.TipoLibroM;

public interface TipoLibroI {

    void guardar(TipoLibroM tipoLibro) throws Exception;

    void modificar(TipoLibroM tipoLibro) throws Exception;

    void eliminar(TipoLibroM tipoLibro) throws Exception; // cambia de estado al tipo de libro por I 

    void activar(TipoLibroM tipoLibro) throws Exception; // cambia de estado al tipo de libro por A 

    List<TipoLibroM> listar() throws Exception;
}
