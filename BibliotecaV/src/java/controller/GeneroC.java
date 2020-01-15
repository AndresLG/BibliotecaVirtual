package controller;

import dao.GeneroD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.GeneroM;

@Named(value = "generoC")
@SessionScoped
public class GeneroC implements Serializable {

    GeneroM genero = new GeneroM();
    private List<GeneroM> lstGenero;
    private GeneroM selectedGenero;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        genero = new GeneroM();
    }

    public void guardar() {
        GeneroD dao;
        try {
            dao = new GeneroD();
            dao.guardar(genero);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"GUARDADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO AGREGAR",null));
        }
    }

    public void modificar() {
        GeneroD dao;
        try {
            dao = new GeneroD();
            dao.modificar(selectedGenero);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"MODIFICADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO MODIFICAR",null));
        }
    }

    public void eliminar() {
        GeneroD dao;
        try {
            dao = new GeneroD();
            dao.eliminar(selectedGenero);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ELIMINADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO ELIMINAR",null));
        }
    }

    public void listar() throws Exception {
        GeneroD dao;
        try {
            dao = new GeneroD();
            lstGenero = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public GeneroM getGenero() {
        return genero;
    }

    public void setGenero(GeneroM genero) {
        this.genero = genero;
    }

    public List<GeneroM> getLstGenero() {
        return lstGenero;
    }

    public void setLstGenero(List<GeneroM> lstGenero) {
        this.lstGenero = lstGenero;
    }

    public GeneroM getSelectedGenero() {
        return selectedGenero;
    }

    public void setSelectedGenero(GeneroM selectedGenero) {
        this.selectedGenero = selectedGenero;
    }
}
