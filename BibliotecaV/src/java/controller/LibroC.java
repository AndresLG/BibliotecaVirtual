package controller;

import dao.LibroD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.LibroM;

@Named(value = "libroC")
@SessionScoped
public class LibroC implements Serializable {

    LibroM libro = new LibroM();
    private List<LibroM> lstlibro;
    private List<LibroM> lstConsulta;

    private String titulo = null;
    private String autor = null;
    
    private int totLibros = 0;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
            totalLibros();
        } catch (Exception e) {
        }
    }
    
    public void limpiar() {
        libro = new LibroM();
        titulo = null;
        autor = null;
    }

    public void guardar() throws Exception {
        LibroD dao;
        try {
            dao = new LibroD();
            dao.guardar(libro);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO CON EXITO"));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO AGREGAR"));
            throw e;
        }
    }

    public void modificar() throws Exception {
        LibroD dao;
        try {
            dao = new LibroD();
            dao.modificar(libro);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO CON EXITO"));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO ACTUALIZAR"));
            throw e;
        }
    }

    public void eliminar() throws Exception {
        LibroD dao;
        try {
            dao = new LibroD();
            dao.eliminar(libro);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO CON EXITO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO ELIMINAR"));
            throw e;
        }
    }

    public void activar() throws Exception {
        LibroD dao;
        try {
            dao = new LibroD();
            dao.activar(libro);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTIVADO CON EXITO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO ACTIVAR"));
            throw e;
        }
    }

    public void listar() throws Exception {
        LibroD dao;
        try {
            dao = new LibroD();
            lstlibro = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void consultar() throws Exception {
        LibroD dao;
        try {
            dao = new LibroD();
            lstConsulta = dao.consultar(titulo, autor);
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<String> completeTextLibro(String query) throws SQLException, Exception {
        LibroD dao = new LibroD();
        return dao.queryAutoCompleteLibro(query);
    }
    
    public void totalLibros() {
        LibroD dao;
        try {
            dao = new LibroD();
            setTotLibros(dao.totalLibros());
        } catch (Exception e) {
        }
    }

    public LibroM getLibro() {
        return libro;
    }

    public void setLibro(LibroM libro) {
        this.libro = libro;
    }

    public List<LibroM> getLstlibro() {
        return lstlibro;
    }

    public void setLstlibro(List<LibroM> lstlibro) {
        this.lstlibro = lstlibro;
    }

    public List<LibroM> getLstConsulta() {
        return lstConsulta;
    }

    public void setLstConsulta(List<LibroM> lstConsulta) {
        this.lstConsulta = lstConsulta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotLibros() {
        return totLibros;
    }

    public void setTotLibros(int totLibros) {
        this.totLibros = totLibros;
    }
}
