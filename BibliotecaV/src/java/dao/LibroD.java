package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.LibroM;
import interfaces.LibroI;

public class LibroD extends Dao implements LibroI {

     @Override
    public void guardar(LibroM libro) throws Exception {
        try {
            this.conectar();
            String sql="insert into Libro (ISBNLIB,TITLIB,FECPUBLIB,CODAUT,CODGEN,CODEDIT,PAGLIB,DESCLIB,TAMLIB,CODTIPOLIB,CODANQ,ESTLIB) values(?,?,TO_DATE(?, 'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, libro.getISBNLIB());
            st.setString(2, libro.getTITLIB());
            st.setString(3, libro.getFECPUBLIB());
            st.setString(4, libro.getCODAUT());
            st.setString(5, libro.getCODGEN());
            st.setString(6, libro.getCODEDIT());
            st.setString(7, libro.getPAGLIB());
            st.setString(8, libro.getDESCLIB());
            st.setString(9, libro.getTAMLIB());
            st.setString(10, libro.getCODTIPOLIB());
            st.setString(11, libro.getCODANQ());
            st.setString(12, libro.getESTLIB());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(LibroM libro) throws Exception {
        try {
            this.conectar();
            String sql="UPDATE Libro SET ISBNLIB=?,TITLIB=?,FECPUBLIB=TO_DATE(?, 'YYYY'),CODAUT=?,CODGEN=?,CODEDIT=?,PAGLIB=?,DESCLIB=?,TAMLIB=?,CODTIPOLIB=?,CODANQ=?,ESTLIB=? WHERE CODLIB=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, libro.getISBNLIB());
            st.setString(2, libro.getTITLIB());
            st.setString(3, libro.getFECPUBLIB());
            st.setString(4, libro.getCODAUT());
            st.setString(5, libro.getCODGEN());
            st.setString(6, libro.getCODEDIT());
            st.setString(7, libro.getPAGLIB());
            st.setString(8, libro.getDESCLIB());
            st.setString(9, libro.getTAMLIB());
            st.setString(10, libro.getCODTIPOLIB());
            st.setString(11, libro.getCODANQ());
            st.setString(12, libro.getESTLIB());
            st.setInt(13, libro.getCODLIB());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(LibroM libro) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Libro SET ESTLIB =? WHERE CODLIB=?");
            st.setString(1, "I");
            st.setInt(2, libro.getCODLIB());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void activar(LibroM libro) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Libro SET ESTLIB =? WHERE CODLIB=?");
            st.setString(1, "A");
            st.setInt(2, libro.getCODLIB());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<LibroM> listar() throws Exception {
        List<LibroM> lista;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "select * from vw_Libro ORDER BY CODLIB DESC";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                LibroM libro = new LibroM();
                libro.setCODLIB(rs.getInt("CODLIB"));
                libro.setISBNLIB(rs.getString("ISBNLIB"));
                libro.setTITLIB(rs.getString("TITLIB"));
                libro.setFECPUBLIB(rs.getString("FECPUBLIB"));
                libro.setCODAUT(rs.getString("CODAUT"));
                libro.setNOMBREAUT(rs.getString("Autor"));
                libro.setCODGEN(rs.getString("CODGEN"));
                libro.setNOMBREGEN(rs.getString("Genero"));
                libro.setCODEDIT(rs.getString("CODEDIT"));
                libro.setNOMBREEDIT(rs.getString("Editorial"));
                libro.setPAGLIB(rs.getString("PAGLIB"));
                libro.setDESCLIB(rs.getString("DESCLIB"));
                libro.setTAMLIB(rs.getString("TAMLIB"));
                libro.setCODTIPOLIB(rs.getString("CODTIPOLIB"));
                libro.setNOMBRETIPOLIB(rs.getString("Tipo_Libro"));
                libro.setCODANQ(rs.getString("CODANQ"));
                libro.setNOMBREANQ(rs.getString("Anaquel"));
                libro.setESTLIB(rs.getString("ESTLIB"));
                lista.add(libro);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
    //    @Override
    public List<LibroM> consultar(String titulo, String autor) throws Exception {
        List<LibroM> consulta;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM VW_LIBROBUSQUEDA WHERE TITLIB LIKE ? OR NOMPER || ' ' ||APEPER  LIKE ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, titulo);
            ps.setString(2, autor);
//            ps.setString(3, apellido);
//            ps.setString(4, genero);
//            ps.setString(5, editorial);
            rs = ps.executeQuery();
            consulta = new ArrayList();
            LibroM libro;
            while(rs.next()){
                libro = new LibroM();
                libro.setCODLIB(rs.getInt("CODLIB"));
                libro.setTITLIB(rs.getString("TITLIB"));
                libro.setFECPUBLIB(rs.getString("FECPUBLIB"));
                libro.setPAGLIB(rs.getString("PAGLIB"));
                libro.setDESCLIB(rs.getString("DESCLIB"));
                libro.setTAMLIB(rs.getString("TAMLIB"));
                libro.setESTLIB(rs.getString("ESTLIB"));
                libro.setNOMAUT(rs.getString("NOMPER"));
                libro.setAPEAUT(rs.getString("APEPER"));
                libro.setESTAUT(rs.getString("ESTPER"));
                libro.setNOMGEN(rs.getString("NOMGEN"));
                libro.setESTGEN(rs.getString("ESTGEN"));
                libro.setNOMEDIT(rs.getString("NOMEDIT"));
                libro.setESTEDIT(rs.getString("ESTEDIT"));
                libro.setNOMANQ(rs.getString("NOMANQ"));
                libro.setESTANQ(rs.getString("ESTANQ"));
                consulta.add(libro);
            }
            return consulta;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
    public List<String> queryAutoCompleteLibro(String a) throws SQLException, Exception {
        this.conectar();
        ResultSet rs;
        List<String> lista;
        try {
            String sql = "SELECT TITLIB FROM VW_LIBROBUSQUEDA WHERE TITLIB LIKE ? AND ESTLIB LIKE 'Disponible'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + a + "%");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("TITLIB"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public int totalLibros() throws Exception {
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT COUNT(*) TOTALLIBROS FROM VW_LIBROBUSQUEDA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("TOTALLIBROS");
            }
            return 0;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
}
