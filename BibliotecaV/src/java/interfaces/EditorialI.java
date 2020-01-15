package interfaces;

import java.util.List;
import model.EditorialM;

public interface EditorialI {

    void guardarEditorial(EditorialM editorial) throws Exception;

    void modificarEditorial(EditorialM editorial) throws Exception;

    void eliminarEditorial(EditorialM editorial) throws Exception; // cambia de estado a la evaluación por I 

    List<EditorialM> listarEditorial() throws Exception;
}
