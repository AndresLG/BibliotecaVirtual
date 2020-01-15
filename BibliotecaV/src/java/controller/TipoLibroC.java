package controller;

import dao.TipoLibroD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.TipoLibroM;

@Named(value = "tipoLibroC")
@SessionScoped
public class TipoLibroC implements Serializable {

    TipoLibroM tipoLibro = new TipoLibroM();
    private List<TipoLibroM> lstTipoLibro;
    private TipoLibroM selectedTipoLibro;
    
    @PostConstruct
    public void iniciar(){
        try {
            listar();
        } catch (Exception e) {
        }
    }
    
    public void limpiar(){
        tipoLibro = new TipoLibroM();
    }
    
    public void guardar() {
        TipoLibroD dao;
        try {
            dao = new TipoLibroD();
            dao.guardar(tipoLibro);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"GUARDADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO AGREGAR",null));
        }
    }
    
    public void modificar() {
        TipoLibroD dao;
        try {
            dao = new TipoLibroD();
            dao.modificar(selectedTipoLibro);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"MODIFICADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO MODIFICAR",null));
        }
    }
    
    public void eliminar() {
        TipoLibroD dao;
        try {
            dao = new TipoLibroD();
            dao.eliminar(selectedTipoLibro);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ELIMINADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO ELIMINAR",null));
        }
    }
    
    public void listar() throws Exception {
        TipoLibroD dao;
        try {
            dao = new TipoLibroD();
            lstTipoLibro = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public TipoLibroM getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(TipoLibroM tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public List<TipoLibroM> getLstTipoLibro() {
        return lstTipoLibro;
    }

    public void setLstTipoLibro(List<TipoLibroM> lstTipoLibro) {
        this.lstTipoLibro = lstTipoLibro;
    }

    public TipoLibroM getSelectedTipoLibro() {
        return selectedTipoLibro;
    }

    public void setSelectedTipoLibro(TipoLibroM selectedTipoLibro) {
        this.selectedTipoLibro = selectedTipoLibro;
    }
}
