package interfaces;

import java.util.List;
import model.LectorM;

public interface LectorI {
    
    void guardarLector(LectorM lector)throws Exception;
    
    void modificarLector(LectorM lector)throws Exception;
    
    void eliminarLector(LectorM lector)throws Exception; // cambia de estado al lector por I 
   
    List<LectorM>listarLector() throws Exception;
}
