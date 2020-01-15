package dao;

import interfaces.LectorI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.LectorM;

public class LectorD extends Dao implements LectorI{

    @Override
    public void guardarLector(LectorM lector) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PERSONA (NOMPER,APEPER,DNIPER,DIRPER,TELFPER,EMAPER,PASPER,TIPPER,ESTPER) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, lector.getNOMLEC());
            ps.setString(2, lector.getAPELEC());
            ps.setString(3, lector.getDNILEC());
            ps.setString(4, lector.getDIRLEC());
            ps.setString(5, lector.getTELFLEC());
            ps.setString(6, lector.getEMALEC());
            ps.setString(7, lector.getPASLEC());
            ps.setString(8, lector.getTIPPER());
            ps.setString(9, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarLector(LectorM lector) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PERSONA SET NOMPER=?, APEPER=?, DIRPER=?, TELF=?, TIPPER=? WHERE CODPER=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, lector.getNOMLEC());
            ps.setString(2, lector.getAPELEC());
            ps.setString(3, lector.getDIRLEC());
            ps.setString(4, lector.getTELFLEC());
            ps.setString(5, lector.getTIPPER());
            ps.setString(6, lector.getCODLEC());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminarLector(LectorM lector) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PERSONA SET ESTPER= ? WHERE CODPER= ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, lector.getCODLEC());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<LectorM> listarLector() throws Exception {
        List<LectorM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM vw_Lector ORDER BY CODPER DESC";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                LectorM lector = new LectorM();
                lector.setCODLEC(rs.getString("CODPER"));
                lector.setNOMLEC(rs.getString("NOMPER"));
                lector.setAPELEC(rs.getString("APEPER"));
                lector.setDNILEC(rs.getString("DNIPER"));
                lector.setDIRLEC(rs.getString("DIRPER"));
                lector.setTELFLEC(rs.getString("TELFPER"));
                lector.setEMALEC(rs.getString("EMAPER"));
                lector.setPASLEC(rs.getString("PASPER"));
                lector.setTIPPER(rs.getString("TIPPER"));
                lector.setESTLEC(rs.getString("ESTPER"));
                lista.add(lector);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
