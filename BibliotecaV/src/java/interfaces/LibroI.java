package interfaces;

import java.util.List;
import model.LibroM;

public interface LibroI {

    void guardar(LibroM libro) throws Exception;

    void modificar(LibroM libro) throws Exception;

    void eliminar(LibroM libro) throws Exception; // cambia de estado del libro por I 

    void activar(LibroM libro) throws Exception; // cambia de estado del libro por A 

    List<LibroM> listar() throws Exception;
    
    //    List<LibroM> consultar(String titulo, String nombre, String apellido, String genero, String editorial) throws Exception;
}
