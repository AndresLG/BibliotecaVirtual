package controller;

import dao.AutorD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.AutorM;

@Named(value = "autorC")
@SessionScoped
public class AutorC implements Serializable {

    AutorM autor = new AutorM();
    private List<AutorM> lstAutor;
    private AutorM selectedAutor;

    @PostConstruct
    public void iniciar(){
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        autor = new AutorM();
    }

    public void guardar() throws Exception {
        AutorD dao;
        try {
            dao = new AutorD();
            dao.guardarAutor(autor);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"GUARDADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO AGREGAR",null));
            throw e;
        }
    }

    public void modificar() {
        AutorD dao;
        try {
            dao = new AutorD();
            dao.modificarAutor(selectedAutor);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"MODIFICADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO MODIFICAR",null));
        }
    }
    
    public void eliminar() {
        AutorD dao;
        try {
            dao = new AutorD();
            dao.eliminarAutor(selectedAutor);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ELIMINADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO ELIMINAR",null));
        }
    }

    public void listar() throws Exception {
        AutorD dao;
        try {
            dao = new AutorD();
            lstAutor = dao.listarAutor();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<String> completeTextAutor(String query) throws SQLException, Exception {
        AutorD dao = new AutorD();
        return dao.queryAutoCompleteAutor(query);
    }

    public AutorM getAutor() {
        return autor;
    }

    public void setAutor(AutorM autor) {
        this.autor = autor;
    }

    public List<AutorM> getLstAutor() {
        return lstAutor;
    }

    public void setLstAutor(List<AutorM> lstAutor) {
        this.lstAutor = lstAutor;
    }

    public AutorM getSelectedAutor() {
        return selectedAutor;
    }

    public void setSelectedAutor(AutorM selectedAutor) {
        this.selectedAutor = selectedAutor;
    }
}
