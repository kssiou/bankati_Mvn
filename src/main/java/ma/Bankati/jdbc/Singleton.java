package ma.Bankati.jdbc;

import javax.swing.*;
import java.sql.*;

public class Singleton {
    private static Connection connection ;
    private Singleton(){
        String url ="jdbc:mysql://localhost:3306/bankati",
                username="root",
                password="",
                driver="com.mysql.cj.jdbc.Driver";
        PreparedStatement ps = null ;
        ResultSet rs=null ;
        ResultSetMetaData metadata=null ;
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,password);
            JOptionPane.showMessageDialog(null,"Connection a la BD a ete charge avec succes ^_^", "SESSION OUVERTE", JOptionPane.INFORMATION_MESSAGE);

            System.out.println();
            ps=connection.prepareStatement("SELECT * FROM credit");
            ps.executeQuery();
            rs=ps.executeQuery();

            metadata= rs.getMetaData();
            System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            while(rs.next()) {

                for ( int i =0; i <= metadata.getColumnCount();i++) {

                    System.out.printf("\t" + metadata.getColumnName(i).toUpperCase() + " : " + rs.getObject(i).toString() + "  \t |");

                }
                System.out.printf("\n----------------------------------------------------------------------------------------------------------------------------------------------------------- \n");

            }
        }
        catch (Exception e){e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de Connection", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection getconnection(){
            if(connection == null) new Singleton();
            return connection;
        }

    public static void main(String[] args) {
        getconnection();
    }






}
