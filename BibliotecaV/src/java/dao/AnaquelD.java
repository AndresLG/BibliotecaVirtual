package dao;

import interfaces.AnaquelI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AnaquelM;

public class AnaquelD extends Dao implements AnaquelI{

    @Override
    public void guardar(AnaquelM anaquel) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO ANAQUEL(NOMANQ,ESTANQ,COLANQ,FILANQ) VALUES(?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, anaquel.getNOMANQ());
            ps.setString(2, "A");
            ps.setString(3, anaquel.getCOLANQ());
            ps.setString(4, anaquel.getFILANQ());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(AnaquelM anaquel) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE ANAQUEL SET NOMANQ=?, ESTANQ=?, COLANQ=?, FILANQ=? WHERE CODANQ = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, anaquel.getNOMANQ());
            ps.setString(2, anaquel.getESTANQ());
            ps.setString(3, anaquel.getCOLANQ());
            ps.setString(4, anaquel.getFILANQ());
            ps.setString(5, anaquel.getCODANQ());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(AnaquelM anaquel) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE ANAQUEL SET ESTANQ = ? WHERE CODANQ = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, anaquel.getCODANQ());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void activar(AnaquelM anaquel) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE ANAQUEL SET ESTANQ = ? WHERE CODANQ = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, "A");
            st.setString(2, anaquel.getCODANQ());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<AnaquelM> listar() throws Exception {
        List<AnaquelM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM ANAQUEL WHERE ESTANQ LIKE 'A' ORDER BY CODANQ";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                AnaquelM anaquel = new AnaquelM();
                anaquel.setCODANQ(rs.getString("CODANQ"));
                anaquel.setNOMANQ(rs.getString("NOMANQ"));
                anaquel.setESTANQ(rs.getString("ESTANQ"));
                anaquel.setCOLANQ(rs.getString("COLANQ"));
                anaquel.setFILANQ(rs.getString("FILANQ"));
                lista.add(anaquel);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
}
