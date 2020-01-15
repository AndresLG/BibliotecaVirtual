package controller;

import dao.PersonaD;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.PersonaM;
import org.primefaces.context.RequestContext;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    /* OBJETO DE SESION */
    private PersonaM persona = new PersonaM();
    private List<PersonaM> lstPersona;

    /* VARIABLES DE LOGUEO */
    private String User;
    private String Pass;

    /* VARIABLES PARA EL BLOQUEO */
    private int intentos, numero;

    public void listar() throws Exception {
        PersonaD dao;
        try {
            dao = new PersonaD();
            lstPersona = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void incrementar() {
        numero++;
        if (numero > 5) {
            numero = 0;
            intentos = 0;
            RequestContext.getCurrentInstance().execute(" location.reload (); ");
        }
    }

    public void iniciarSesion() throws Exception {
        PersonaD dao;
        try {
            dao = new PersonaD();
            persona = dao.iniciarSesion(User, Pass);
            if (persona != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombreUsuario", persona);
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/vistas/dashboard/dashboard.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Contraseña/Usuario Incorrecto", null));
                intentos++;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* CIERA LA SESION */
    public void cerrarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear(); // CIERRA LA SESION
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Biblioteca"); // MANDAMOS AL LOGUIN
    }

    /* SI LA SESION YA ESTA INICIADA, REDIRECCIONA A ESTA VISTA */
    public void seguridadLogin() throws IOException {
        PersonaM us = obtenerObjetoSesion();
        if (us != null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/vistas/dashboard/dashboard.xhtml");
        }
    }

    /* NO PERMITE INGRESAR A NINGUNA VISTA SI LA SESION NO ESTÁ INICIADA */
    public void seguridadSesion() throws IOException {
        if (obtenerObjetoSesion() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Biblioteca");
        }
    }

    public static PersonaM obtenerObjetoSesion() {
        return (PersonaM) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombreUsuario");
    }

    public PersonaM getPersona() {
        return persona;
    }

    public void setPersona(PersonaM persona) {
        this.persona = persona;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public List<PersonaM> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<PersonaM> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
