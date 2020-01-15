package interfaces;

import java.util.List;
import model.GeneroM;

public interface GeneroI {
    
    void guardar(GeneroM genero)throws Exception;
    
    void modificar(GeneroM genero)throws Exception;
    
    void eliminar(GeneroM genero)throws Exception; // cambia de estado a la evaluación por I 
    
    void activar(GeneroM genero)throws Exception; // cambia de estado a la evaluación por A 
    
    List<GeneroM> listar() throws Exception;
}
