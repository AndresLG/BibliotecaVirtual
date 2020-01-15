
package dao;

import interfaces.EditorialI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EditorialM;


public class EditorialD extends Dao implements EditorialI{

    @Override
    public void guardarEditorial(EditorialM editorial) throws Exception {
         try {
            this.conectar();
            String sql = "INSERT INTO EDITORIAL (NOMEDIT,ESTEDIT) VALUES(?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, editorial.getNOMEDIT());
            ps.setString(2, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void modificarEditorial(EditorialM editorial) throws Exception {
         try {
            this.conectar();
            String sql = "UPDATE EDITORIAL SET NOMEDIT= ? WHERE CODEDIT=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, editorial.getNOMEDIT());
            ps.setString(2, editorial.getCODEDIT());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void eliminarEditorial(EditorialM editorial) throws Exception {
          try {
            this.conectar();
            String sql = "UPDATE EDITORIAL SET ESTEDIT= ? WHERE CODEDIT= ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, editorial.getCODEDIT());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<EditorialM> listarEditorial() throws Exception {
         List<EditorialM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM EDITORIAL WHERE ESTEDIT LIKE 'A' ORDER BY CODEDIT";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EditorialM editorial = new EditorialM();
                editorial.setCODEDIT(rs.getString("CODEDIT"));
                editorial.setNOMEDIT(rs.getString("NOMEDIT"));
                editorial.setESTEDIT(rs.getString("ESTEDIT"));
                lista.add(editorial);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
