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
        int i;

        try {
            Class.forName(driver);
            System.out.println("Le driver de Mysql a ete charge avec succes ^_^");
            connection = DriverManager.getConnection(url,login,pass);
            System.out.println("Connection a la BD a ete charge avec succes ^_^");
            ps=connection.prepareStatement("SELECT * FROM credit");
            rs=ps.executeQuery();

            metadata= rs.getMetaData();
            System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            while(rs.next()) {

                for ( i = 1; i <= metadata.getColumnCount();i++) {

                    System.out.printf("\t" + metadata.getColumnName(i).toUpperCase() + " : " + rs.getObject(i).toString() + "  \t |");

                }
                System.out.printf("\n----------------------------------------------------------------------------------------------------------------------------------------------------------- \n");

            }



        } catch (ClassNotFoundException e) {
            System.err.println("Le driver de MySQL est introuvable");
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
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
