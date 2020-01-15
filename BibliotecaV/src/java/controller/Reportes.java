
package controller;

import dao.Dao;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Reportes  extends Dao {
     Date ahora = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");

    public void exportarPDF(Map parameters) throws JRException, IOException, Exception {
        this.conectar();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/report/BibliotecaV.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Prestamo" + formateador.format(ahora)+ ".pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void exportarAutorPDF(Map parameters) throws JRException, IOException, Exception {
        this.conectar();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/report/Autores.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Autores" + formateador.format(ahora)+ ".pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    
     public void exportarLibroPDF(Map parameters) throws JRException, IOException, Exception {
        this.conectar();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/report/Libro.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Autores" + formateador.format(ahora)+ ".pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
   
}
