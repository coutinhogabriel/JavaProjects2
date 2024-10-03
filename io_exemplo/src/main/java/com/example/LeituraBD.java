package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LeituraBD {
    public void exemplo() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "postgres");
            Statement stmt = con.createStatement();
            // armazenar os resultados
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

            // printar o resultado
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
