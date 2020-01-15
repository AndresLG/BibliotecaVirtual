package controller;

import dao.EditorialD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.EditorialM;

@Named(value = "editorialC")
@SessionScoped
public class EditorialC implements Serializable {

    EditorialM editorial = new EditorialM();
    private List<EditorialM> lstEditorial;
    private EditorialM selectedEditorial;
    
    @PostConstruct
    public void iniciar(){
        try {
            listar();
        } catch (Exception e) {
        }
    }
    
    public void limpiar(){
        editorial = new EditorialM();
    }
    
    public void guardar() {
        EditorialD dao;
        try {
            dao = new EditorialD();
            dao.guardarEditorial(editorial);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"GUARDADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO AGREGAR",null));
        }
    }
    
    public void modificar() {
        EditorialD dao;
        try {
            dao = new EditorialD();
            dao.modificarEditorial(selectedEditorial);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"MODIFICADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO MODIFICAR",null));
        }
    }
    
    public void eliminar() {
        EditorialD dao;
        try {
            dao = new EditorialD();
            dao.eliminarEditorial(selectedEditorial);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"ELIMINADO CON ÉXITO",null ));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"NO SE PUDO ELIMINAR",null));
        }
    }
    
    public void listar() throws Exception {
        EditorialD dao;
        try {
            dao = new EditorialD();
            lstEditorial = dao.listarEditorial();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public EditorialM getEditorial() {
        return editorial;
    }

    public void setEditorial(EditorialM editorial) {
        this.editorial = editorial;
    }

    public List<EditorialM> getLstEditorial() {
        return lstEditorial;
    }

    public void setLstEditorial(List<EditorialM> lstEditorial) {
        this.lstEditorial = lstEditorial;
    }

    public EditorialM getSelectedEditorial() {
        return selectedEditorial;
    }

    public void setSelectedEditorial(EditorialM selectedEditorial) {
        this.selectedEditorial = selectedEditorial;
    }   
}