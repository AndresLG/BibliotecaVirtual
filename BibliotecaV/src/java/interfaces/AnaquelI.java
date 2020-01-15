package interfaces;

import java.util.List;
import model.AnaquelM;

public interface AnaquelI {

    void guardar(AnaquelM anaquel) throws Exception;

    void modificar(AnaquelM anaquel) throws Exception;

    void eliminar(AnaquelM anaquel) throws Exception; // cambia de estado a la evaluación por I 

    void activar(AnaquelM anaquel) throws Exception; // cambia de estado a la evaluación por A 

    List<AnaquelM> listar() throws Exception;
}
