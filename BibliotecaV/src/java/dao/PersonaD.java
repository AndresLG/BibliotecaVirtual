package dao;

import interfaces.IPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PersonaM;

public class PersonaD extends Dao implements IPersona{

    @Override
    public PersonaM iniciarSesion(String User, String Pass) throws Exception {
        this.conectar();
        ResultSet rs;
        PersonaM persona = null;
        try {
            String sql = "SELECT CODPER, APEPER, DNIPER, DIRPER, TELFPER, TIPPER FROM PERSONA WHERE NOMPER LIKE ? AND PASPER LIKE ? AND ESTPER LIKE 'A'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                persona = new PersonaM();
                persona.setCODPER(rs.getString("CODPER"));
                persona.setAPEPER(rs.getString("APEPER"));
                persona.setDNIPER(rs.getString("DNIPER"));
                persona.setDIRPER(rs.getString("DIRPER"));
                persona.setTELFPER(rs.getString("TELFPER"));
                persona.setTIPPER(rs.getString("TIPPER"));
                persona.setNOMPER(User);
                persona.setPASPER(Pass);
            }
            return persona;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void guardar(PersonaM persona) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(PersonaM persona) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(PersonaM persona) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void activar(PersonaM persona) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaM> listar() throws Exception {
        List<PersonaM> listaPersona;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM PERSONA WHERE ESTPER LIKE 'A'";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaPersona = new ArrayList();
            PersonaM persona;
            while(rs.next()){
                persona = new PersonaM();
                persona.setCODPER(rs.getString("CODPER"));
                persona.setNOMPER(rs.getString("NOMPER"));
                persona.setAPEPER(rs.getString("APEPER"));
                persona.setDNIPER(rs.getString("DNIPER"));
                persona.setDIRPER(rs.getString("DIRPER"));
                persona.setTELFPER(rs.getString("TELFPER"));
                persona.setPASPER(rs.getString("PASPER"));
                persona.setTIPPER(rs.getString("TIPPER"));
                persona.setESTPER(rs.getString("ESTPER"));
                listaPersona.add(persona);
            }
            return listaPersona;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
}
