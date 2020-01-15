package dao;

import interfaces.GeneroI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GeneroM;

public class GeneroD extends Dao implements GeneroI {

    @Override
    public void guardar(GeneroM genero) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO GENERO (NOMGEN,ESTGEN) VALUES(?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, genero.getNOMGEN());
            ps.setString(2, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(GeneroM genero) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE GENERO SET NOMGEN = ? WHERE CODGEN = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, genero.getNOMGEN());
            ps.setString(2, genero.getCODGEN());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(GeneroM genero) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE GENERO SET ESTGEN = ? WHERE CODGEN = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, genero.getCODGEN());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void activar(GeneroM genero) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE GENERO SET ESTGEN = ? WHERE CODGEN = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "A");
            ps.setString(2, genero.getCODGEN());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<GeneroM> listar() throws Exception {
        List<GeneroM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM GENERO WHERE ESTGEN LIKE 'A' ORDER BY CODGEN";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                GeneroM genero = new GeneroM();
                genero.setCODGEN(rs.getString("CODGEN"));
                genero.setNOMGEN(rs.getString("NOMGEN"));
                genero.setESTGEN(rs.getString("ESTGEN"));
                lista.add(genero);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
