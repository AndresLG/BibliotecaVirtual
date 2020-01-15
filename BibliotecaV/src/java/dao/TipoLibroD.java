
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TipoLibroM;
import interfaces.TipoLibroI;


public class TipoLibroD extends Dao implements TipoLibroI{

    @Override
    public void guardar(TipoLibroM tipoLibro) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO TIPO_LIBRO (NOMTIPOLIB,ESTTIPOLIB) VALUES (?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tipoLibro.getNOMTIPOLIB());
            ps.setString(2, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(TipoLibroM tipoLibro) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE TIPO_LIBRO SET NOMTIPOLIB = ? WHERE CODTIPOLIB = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tipoLibro.getNOMTIPOLIB());
            ps.setInt(2, tipoLibro.getCODTIPOLIB());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(TipoLibroM tipoLibro) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE TIPO_LIBRO SET ESTTIPOLIB = ? WHERE CODTIPOLIB = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, tipoLibro.getCODTIPOLIB());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void activar(TipoLibroM tipoLibro) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE TIPO_LIBRO SET ESTTIPOLIB = ? WHERE CODTIPOLIB = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "A");
            ps.setInt(2, tipoLibro.getCODTIPOLIB());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<TipoLibroM> listar() throws Exception {
        List<TipoLibroM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM TIPO_LIBRO WHERE ESTTIPOLIB LIKE 'A' ORDER BY CODTIPOLIB";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                TipoLibroM genero = new TipoLibroM();
                genero.setCODTIPOLIB(rs.getInt("CODTIPOLIB"));
                genero.setNOMTIPOLIB(rs.getString("NOMTIPOLIB"));
                genero.setESTTIPOLIB(rs.getString("ESTTIPOLIB"));
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
