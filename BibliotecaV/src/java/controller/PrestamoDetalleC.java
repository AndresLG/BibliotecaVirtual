package controller;

import dao.PrestamoDetalleD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.PrestamoDetalleM;

@Named(value = "prestamoDetalleC")
@SessionScoped
public class PrestamoDetalleC implements Serializable {

    private PrestamoDetalleM prestamoDetalle = new PrestamoDetalleM();
    private List<PrestamoDetalleM> lstprestamoDetalle;
    private List<PrestamoDetalleM> lstdevolucion;

    @PostConstruct
    public void iniciar() {
        try {
            list();
            listDev();
        } catch (Exception e) {
        }
    }

    public void preparPrestamoDetalle() {
        prestamoDetalle = new PrestamoDetalleM();
    }

    public void add() throws Exception {
        PrestamoDetalleD dao;
        try {
            dao = new PrestamoDetalleD();
            dao.guardar(prestamoDetalle);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO CON EXITO"));
            preparPrestamoDetalle();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO AGREGAR"));
            throw e;
        }
    }

    public void update() throws Exception {
        PrestamoDetalleD dao;
        try {
            dao = new PrestamoDetalleD();
            dao.modificar(prestamoDetalle);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO CON EXITO"));
            preparPrestamoDetalle();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO ACTUALIZAR"));
            throw e;
        }
    }

    public void delete() throws Exception {
        PrestamoDetalleD dao;
        try {
            dao = new PrestamoDetalleD();
            dao.eliminar(prestamoDetalle);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO CON EXITO"));
            preparPrestamoDetalle();
            listDev();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO ELIMINAR"));
            throw e;
        }
    }

    public void activate() throws Exception {
        PrestamoDetalleD dao;
        try {
            dao = new PrestamoDetalleD();
            dao.activar(prestamoDetalle);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTIVADO CON EXITO"));
            preparPrestamoDetalle();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO ACTIVAR"));
            throw e;
        }
    }

    public void list() throws Exception {
        PrestamoDetalleD dao;
        try {
            dao = new PrestamoDetalleD();
            lstprestamoDetalle = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listDev() throws Exception {
        PrestamoDetalleD dao;
        try {
            dao = new PrestamoDetalleD();
            lstdevolucion = dao.listarDev();
        } catch (Exception e) {
            throw e;
        }
    }

    public PrestamoDetalleM getPrestamoDetalle() {
        return prestamoDetalle;
    }

    public void setPrestamoDetalle(PrestamoDetalleM prestamoDetalle) {
        this.prestamoDetalle = prestamoDetalle;
    }

    public List<PrestamoDetalleM> getLstprestamoDetalle() {
        return lstprestamoDetalle;
    }

    public void setLstprestamoDetalle(List<PrestamoDetalleM> lstprestamoDetalle) {
        this.lstprestamoDetalle = lstprestamoDetalle;
    }

    public List<PrestamoDetalleM> getLstdevolucion() {
        return lstdevolucion;
    }

    public void setLstdevolucion(List<PrestamoDetalleM> lstdevolucion) {
        this.lstdevolucion = lstdevolucion;
    }

}
