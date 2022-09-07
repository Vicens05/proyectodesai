package com.isil.sesion1;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) throws Exception{    //throws Exception para el error con forName

        Class.forName("com.mysql.cj.jdbc.Driver");     //para vincular con el mysql

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TEST",        //TEST es el nombre de la base de datos
                "root",
                "root"

        );

        Statement stmt= con.createStatement();
        //int resultUpdate = stmt.executeUpdate("update Users set city='Barcelona' where name='Messi'");  //para actualizar el dato sin ir a la base de datos

        ResultSet result = stmt.executeQuery("Select * FROM Users"); //mostrar resultado
        //ResultSet result = stmt.executeQuery("Select * FROM Users where name='Messi'");

        while(result.next()){

            System.out.println(result.getString("idUser"));
            System.out.println(result.getString("Name"));
            System.out.println(result.getString("phone"));
            System.out.println(result.getString("city"));

            /*
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
            */
        }

    }

}
