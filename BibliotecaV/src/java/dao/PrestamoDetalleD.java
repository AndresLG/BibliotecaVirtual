package dao;

import interfaces.PrestamoDetalleI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PrestamoDetalleM;

public class PrestamoDetalleD extends Dao implements PrestamoDetalleI{
    
    @Override
    public void guardar(PrestamoDetalleM prestamoDetalle) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PRESTAMO_DETALLE (CODPRE,CODLIB) VALUES (?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, prestamoDetalle.getCODPRE());
            ps.setString(2, prestamoDetalle.getCODLIB());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(PrestamoDetalleM prestamoDetalle) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PRESTAMO_DETALLE SET CODPRE = ?,CODLIB = ? WHERE CODPREDET = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, prestamoDetalle.getCODPRE());
            ps.setString(2, prestamoDetalle.getCODLIB());
            ps.setInt(3, prestamoDetalle.getCODPREDET());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(PrestamoDetalleM prestamoDetalle) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PRESTAMO_DETALLE SET ESTPREDET = ? WHERE CODPREDET = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, prestamoDetalle.getCODPREDET());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void activar(PrestamoDetalleM prestamoDetalle) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PRESTAMO_DETALLE SET ESTPREDET = ? WHERE CODPREDET = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "A");
            ps.setInt(2, prestamoDetalle.getCODPREDET());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<PrestamoDetalleM> listar() throws Exception {
        List<PrestamoDetalleM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM vw_PrestamoDetalle WHERE ESTPREDET = 'A' ORDER BY CODPREDET DESC";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                PrestamoDetalleM prestamoDetalle = new PrestamoDetalleM();
                prestamoDetalle.setCODPREDET(rs.getInt("CODPREDET"));
                prestamoDetalle.setCODPRE(rs.getString("CODPRE"));
                prestamoDetalle.setNOMBREPRE(rs.getString("Prestamo"));
                prestamoDetalle.setCODLIB(rs.getString("CODLIB"));
                prestamoDetalle.setNOMBRELIB(rs.getString("Libro"));
                prestamoDetalle.setESTPREDET(rs.getString("ESTPREDET"));
                prestamoDetalle.setPERSONA(rs.getString("Persona"));
                lista.add(prestamoDetalle);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<PrestamoDetalleM> listarDev() throws Exception {
        List<PrestamoDetalleM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM vw_Devolucion WHERE ESTPREDET = 'I' ORDER BY CODPREDET DESC";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                PrestamoDetalleM devolucion = new PrestamoDetalleM();
                devolucion.setCODPREDET(rs.getInt("CODPREDET"));
                devolucion.setCODPRE(rs.getString("CODPRE"));
                devolucion.setNOMBREPRE(rs.getString("Prestamo"));
                devolucion.setESTPRE(rs.getString("ESTPRE"));
                devolucion.setCODLIB(rs.getString("CODLIB"));
                devolucion.setNOMBRELIB(rs.getString("Libro"));
                devolucion.setESTPREDET(rs.getString("ESTPREDET"));
                devolucion.setPERSONA(rs.getString("Persona"));
                lista.add(devolucion);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
