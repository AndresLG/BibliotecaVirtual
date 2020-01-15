package controller;

import dao.LectorD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.LectorM;

@Named(value = "lectorC")
@SessionScoped
public class LectorC implements Serializable {

    LectorM lector = new LectorM();
    private List<LectorM> lstLector;
    private LectorM selectedLector;

    @PostConstruct
    public void iniciar(){
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        lector = new LectorM();
    }

    public void guardar() {
        LectorD dao;
        try {
            dao = new LectorD();
            dao.guardarLector(lector);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"GUARDADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO AGREGAR",null));
        }
    }

    public void modificar() {
        LectorD dao;
        try {
            dao = new LectorD();
            dao.modificarLector(selectedLector);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"MODIFICADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO MODIFICAR",null));
        }
    }
    
    public void eliminar() {
        LectorD dao;
        try {
            dao = new LectorD();
            dao.eliminarLector(selectedLector);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ELIMINADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO ELIMINAR",null));
        }
    }

    public void listar() throws Exception {
        LectorD dao;
        try {
            dao = new LectorD();
            lstLector = dao.listarLector();
        } catch (Exception e) {
            throw e;
        }
    }

    public LectorM getLector() {
        return lector;
    }

    public void setLector(LectorM lector) {
        this.lector = lector;
    }

    public List<LectorM> getLstLector() {
        return lstLector;
    }

    public void setLstLector(List<LectorM> lstLector) {
        this.lstLector = lstLector;
    }

    public LectorM getSelectedLector() {
        return selectedLector;
    }

    public void setSelectedLector(LectorM selectedLector) {
        this.selectedLector = selectedLector;
    }
    
}
