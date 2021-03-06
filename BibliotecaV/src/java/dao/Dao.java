package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    private Connection cn;

    public void conectar() throws SQLException, ClassNotFoundException {
        try {
              Class.forName("oracle.jdbc.OracleDriver");
//              cn=DriverManager.getConnection("jdbc:oracle:thin:@35.237.73.4:1521:XE","BibliotecaV","vallegrande2018");
              cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BIBLIOTECA","root");
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e);
        }

    }

    public void cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Dao dao = new Dao();
            dao.conectar();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
}
