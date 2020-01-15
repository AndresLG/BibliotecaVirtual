package interfaces;

import java.util.List;
import model.AutorM;

public interface AutorI {
    
    void guardarAutor(AutorM autor)throws Exception;
    
    void modificarAutor(AutorM autor)throws Exception;
    
    void eliminarAutor(AutorM autor)throws Exception; // cambia de estado al autor por I 
   
    List<AutorM>listarAutor() throws Exception;
}
