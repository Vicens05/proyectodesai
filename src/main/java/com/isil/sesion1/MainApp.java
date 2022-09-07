package com.isil.sesion1;

import javax.xml.transform.Result;
import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception{    //throws Exception para el error con forName

        //1. Cargar driver
        Class.forName("com.mysql.cj.jdbc.Driver");     //para vincular con el mysql

        //2. Crear conexión
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TEST",        //TEST es el nombre de la base de datos
                "root",
                "root"

        );

        //3. Crear statement
        //3.1 Statement mantenimiento
        /* INSERTAR
        Statement stCreate = con.createStatement();
        int filasAfectadas =
                stCreate.executeUpdate("insert into Users values (6, 'Maria', '984784798','Quito')");*/
        Statement stCreate = con.createStatement();
        int filasAfectadas =
                stCreate.executeUpdate("UPDATE USERS SET NAME='JUAN' WHERE idUser=1");
        System.out.println("Filas afectadas: " + filasAfectadas);

        //3.2 Statement consulta
        PreparedStatement preparedStatement =
                con.prepareStatement("Select * from Users where idUser=?");

        preparedStatement.setInt(1,1);

        //PreparedStatement preparedStatement =
                //con.prepareStatement("select * from Users where name =? and city=?");
        //primer(1) parametro Cueva(x)
        //preparedStatement.setString(1,"Cueva");
       // preparedStatement.setString(2,"Lima");

        //4. Ejecutar query
        //ResultSet resultSet2 = preparedStatement.executeQuery();
        ResultSet resultSet2 = preparedStatement.executeQuery();


        //5. Recorrer resultados
        while(resultSet2.next()){
            System.out.println(resultSet2.getString("name") +"\n"+
                    resultSet2.getString("phone") +"\n"+
                    resultSet2.getString("city"));
        }

        //6. Cerrar conexion
        con.close();

    }

}
