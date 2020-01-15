package dao;

import interfaces.AutorI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AutorM;

public class AutorD extends Dao implements AutorI {

    @Override
    public void guardarAutor(AutorM autor) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PERSONA (NOMPER,APEPER,TIPPER,ESTPER) VALUES(?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, autor.getNOMAUT());
            ps.setString(2, autor.getAPEAUT());
            ps.setString(3, "AT");
            ps.setString(4, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarAutor(AutorM autor) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PERSONA SET NOMPER=?, APEPER=? WHERE CODPER=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, autor.getNOMAUT());
            ps.setString(2, autor.getAPEAUT());
            ps.setString(3, autor.getCODAUT());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminarAutor(AutorM autor) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PERSONA SET ESTPER= ? WHERE CODPER= ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, autor.getCODAUT());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<AutorM> listarAutor() throws Exception {
        List<AutorM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM vw_Autor WHERE ESTPER LIKE 'A' ORDER BY CODPER";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                AutorM autor = new AutorM();
                autor.setCODAUT(rs.getString("CODPER"));
                autor.setNOMAUT(rs.getString("NOMPER"));
                autor.setAPEAUT(rs.getString("APEPER"));
                autor.setTIPPER(rs.getString("TIPPER"));
                autor.setESTAUT(rs.getString("ESTPER"));
                lista.add(autor);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<String> queryAutoCompleteAutor(String b) throws SQLException, Exception {
        this.conectar();
        ResultSet rs;
        List<String> lista;
        try {
            String sql = "SELECT NOMPER || ' ' || APEPER AUTOR FROM VW_LIBROBUSQUEDA "
                    + "WHERE NOMPER || ' ' || APEPER  LIKE ? AND ESTLIB LIKE 'Disponible'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + b + "%");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("AUTOR"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
