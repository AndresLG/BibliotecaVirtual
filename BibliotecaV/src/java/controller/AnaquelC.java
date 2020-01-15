package controller;

import dao.AnaquelD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.AnaquelM;

@Named(value = "anaquelC")
@SessionScoped
public class AnaquelC implements Serializable {

    AnaquelM anaquel = new AnaquelM();
    private List<AnaquelM> lstAnaquel;
    private AnaquelM selectedAnaquel;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        anaquel = new AnaquelM();
    }

    public void guardar() {
        AnaquelD dao;
        try {
            dao = new AnaquelD();
            dao.guardar(anaquel);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"GUARDADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO AGREGAR",null));
        }
    }

    public void modificar() {
        AnaquelD dao;
        try {
            dao = new AnaquelD();
            dao.modificar(selectedAnaquel);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"MODIFICADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO MODIFICAR",null));
        }
    }

    public void eliminar() {
        AnaquelD dao;
        try {
            dao = new AnaquelD();
            dao.eliminar(selectedAnaquel);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ELIMINADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO ELIMINAR",null));
        }
    }

    public void listar() throws Exception {
        AnaquelD dao;
        try {
            dao = new AnaquelD();
            lstAnaquel = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public AnaquelM getAnaquel() {
        return anaquel;
    }

    public void setAnaquel(AnaquelM anaquel) {
        this.anaquel = anaquel;
    }

    public List<AnaquelM> getLstAnaquel() {
        return lstAnaquel;
    }

    public void setLstAnaquel(List<AnaquelM> lstAnaquel) {
        this.lstAnaquel = lstAnaquel;
    }

    public AnaquelM getSelectedAnaquel() {
        return selectedAnaquel;
    }

    public void setSelectedAnaquel(AnaquelM selectedAnaquel) {
        this.selectedAnaquel = selectedAnaquel;
    }
}
