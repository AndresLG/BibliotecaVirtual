package controller;

import com.sun.corba.se.spi.orb.ORB;
import dao.PrestamoD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Named(value = "demoC")
@SessionScoped
public class DemoC implements Serializable {
     Calendar Cal = Calendar.getInstance();
    
    String fechaActual = Cal.get(Calendar.YEAR) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.DATE);

    public static void main(String[] args) {
        try {
            DemoC demo = new DemoC();
            demo.fechaDev();
        } catch (Exception e) {
        }
    }

    public void fechaDev() throws ParseException {
        String fechaHoy = Cal.get(Calendar.DATE) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.YEAR);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fechaHoy;
        Date fecha = null;
        fecha = formatoDelTexto.parse(strFecha);
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha de Salida: " + formatoDeFecha.format(fecha));
        cal.setTime(fecha);
        cal.add(Calendar.DATE, 3);
        System.out.println("Fecha de Devolución: " + formatoDeFecha.format(cal.getTime()));
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
        }
        if (fechaDevol.before(FechaAct)) {
            System.out.println("Ya venció el tiempo de entrega");
        }
        if (fechaDevol.equals(FechaAct)) {
            System.out.println("Hoy es el día de entrega");
        }

    }
}
