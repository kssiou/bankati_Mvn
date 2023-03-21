package ma.Bankati.jdbc;

import java.sql.*;
import java.util.List;

public class TestJDBC {

    public static void main(String[] args) {
        var url ="jdbc:mysql://localhost:3306/bankati" ;
        var login ="root";
        var pass ="";
        var driver ="com.mysql.cj.jdbc.Driver";
        Connection connection = null ;
        PreparedStatement ps = null ;
        ResultSet rs=null ;
        ResultSetMetaData metadata=null ;

        try {
            Class.forName(driver);
            System.out.println("Le driver de Mysql a ete charge avec succes ^_^");
            connection = DriverManager.getConnection(url,login,pass);
            System.out.println("Connection a la BD a ete charge avec succes ^_^");
            ps=connection.prepareStatement("SELECT * FROM credit");
            rs=ps.executeQuery();
            metadata= rs.getMetaData();

            while(rs.next()){

                System.out.printf(metadata.getColumnName(1)+"\n");


            }
//            ps.setLong(1,3L);
//            ps.setDouble(2,30000.0);


        } catch (ClassNotFoundException e) {
            System.err.println("Le driver de MySQL est introuvable");
        }
        catch (SQLException e) {
            System.err.println("Connection echouee SQL error");
        }
        finally {
            try {
                if (connection !=null){connection.close();
                    System.out.println("Connexion ferme avec succes");}
            } catch (SQLException e) {
                System.err.println("Connexion n'a pas pu etre ferme ");            }
        }
    }
}
