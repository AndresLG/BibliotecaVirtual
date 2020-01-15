package dao;

import interfaces.PrestamoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PrestamoM;

public class PrestamoD extends Dao implements PrestamoI{
    
    @Override
    public void guardar(PrestamoM prestamo) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PRESTAMO (FECSALPRE,FECDEVPRE,CODPER) VALUES (TO_DATE(?, 'DD/MM/YYYY'),TO_DATE(?, 'DD/MM/YYYY'),?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, prestamo.getFECSALPRE());
            ps.setString(2, prestamo.getFECDEVPRE());
            ps.setString(3, prestamo.getCODPER());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(PrestamoM prestamo) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PRESTAMO SET CODPER = ? WHERE CODPRE = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, prestamo.getCODPER());
            ps.setInt(2, prestamo.getCODPRE());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(PrestamoM prestamo) throws Exception {
        
    }

    @Override
    public void desactivar(PrestamoM prestamo) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PRESTAMO SET ESTPRE = ? WHERE CODPRE = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, prestamo.getCODPRE());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<PrestamoM> listar() throws Exception {
        List<PrestamoM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM vw_Prestamo WHERE ESTPRE = 'A' ORDER BY CODPRE DESC";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                PrestamoM prestamo = new PrestamoM();
                prestamo.setCODPRE(rs.getInt("CODPRE"));
                prestamo.setFECSALPRE(rs.getString("FECSALPRE"));
                prestamo.setFECDEVPRE(rs.getString("FECDEVPRE"));
                prestamo.setTOTAL(rs.getInt("TOTAL"));
                prestamo.setCODPER(rs.getString("CODPER"));
                prestamo.setNOMBREPER(rs.getString("Persona"));
                lista.add(prestamo);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
