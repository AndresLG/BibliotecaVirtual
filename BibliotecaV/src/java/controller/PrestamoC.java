package controller;

import dao.PrestamoD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.PrestamoM;

@Named(value = "prestamoC")
@SessionScoped
public class PrestamoC implements Serializable {

    private PrestamoM prestamo = new PrestamoM();
    private List<PrestamoM> lstprestamo;
    private PrestamoM selectedPrestamo;

    String estadoLibro;

    Calendar Cal = Calendar.getInstance();
    String fechaHoy = Cal.get(Calendar.DATE) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.YEAR);

    @PostConstruct
    public void iniciar() {
        try {
            list();
        } catch (Exception e) {
        }
    }

    public void preparPrestamo() {
        prestamo = new PrestamoM();
    }

    public void add() throws Exception {
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            getPrestamo().setFECSALPRE(fechaHoy);
            fechaDev();
            dao.guardar(prestamo);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO CON EXITO"));
            preparPrestamo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO AGREGAR"));
            throw e;
        }
    }

    public void update() throws Exception {
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            dao.modificar(selectedPrestamo);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO CON EXITO"));
            preparPrestamo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO ACTUALIZAR"));
            throw e;
        }
    }

    public void delete() throws Exception {
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            dao.eliminar(selectedPrestamo);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO CON EXITO"));
            preparPrestamo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO ELIMINAR"));
            throw e;
        }
    }

    public void desactivar() throws Exception {
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            dao.desactivar(selectedPrestamo);
            list();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("DEVULETO CON EXITO"));
            preparPrestamo();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO SE PUDO DEVOLVER"));
            throw e;
        }
    }

    public void list() throws Exception {
        PrestamoD dao;
        try {
            dao = new PrestamoD();
            lstprestamo = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void descargarPdfPrestamo() throws Exception {
        Reportes rs;
        try {
            rs = new Reportes();
            Map<String, Object> parameters = new HashMap();
            rs.exportarPDF(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

     public void descargarPdfAutores() throws Exception {
        Reportes rs;
        try {
            rs = new Reportes();
            Map<String, Object> parameters = new HashMap();
            rs.exportarAutorPDF(parameters);
        } catch (Exception e) {
            throw e;
        }
    }
    
      public void descargarPdfLibros() throws Exception {
        Reportes rs;
        try {
            rs = new Reportes();
            Map<String, Object> parameters = new HashMap();
            rs.exportarLibroPDF(parameters);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void fechaDev() throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = getPrestamo().getFECSALPRE();
        Date fecha = null;
        fecha = formatoDelTexto.parse(strFecha);
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha de Salida: " + formatoDeFecha.format(fecha));
        cal.setTime(fecha);
        cal.add(Calendar.DATE, 3);
        System.out.println("Fecha de Devolución: " + formatoDeFecha.format(cal.getTime()));
        getPrestamo().setFECDEVPRE(formatoDeFecha.format(cal.getTime()));
    }

    public void difDias() throws ParseException {
        String fechaActual = Cal.get(Calendar.DATE) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.YEAR);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDevol = sdf.parse("12/12/2018");
        Date FechaAct = sdf.parse(fechaActual);

        System.out.println("date1 : " + sdf.format(fechaDevol));
        System.out.println("date2 : " + sdf.format(FechaAct));

        if (fechaDevol.after(FechaAct)) {
            System.out.println("Aún falta para que devuelva");
            estadoLibro = "Falta";
        }
        if (fechaDevol.before(FechaAct)) {
            System.out.println("Ya venció el tiempo de entrega");
            estadoLibro = "Paso";
        }
        if (fechaDevol.equals(FechaAct)) {
            System.out.println("Hoy es el día de entrega");
            estadoLibro = "Hoy";
        }

    }

    public PrestamoM getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(PrestamoM prestamo) {
        this.prestamo = prestamo;
    }

    public List<PrestamoM> getLstprestamo() {
        return lstprestamo;
    }

    public void setLstprestamo(List<PrestamoM> lstprestamo) {
        this.lstprestamo = lstprestamo;
    }

    public PrestamoM getSelectedPrestamo() {
        return selectedPrestamo;
    }

    public void setSelectedPrestamo(PrestamoM selectedPrestamo) {
        this.selectedPrestamo = selectedPrestamo;
    }

}
