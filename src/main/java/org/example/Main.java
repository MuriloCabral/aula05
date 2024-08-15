package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection connection = MySQLConnection.getConnection();
        if (connection != null) {
            try {

                Carros carro1 = new Carros("ABC-1234", "Fusca", "Azul", 1970);
                Carros carro2 = new Carros("DEF-5678", "Gol", "Preto", 2000);
                Carros carro3 = new Carros("GHI-9101", "Celta", "Branco", 2010);

                Pessoa pessoa1 = new Pessoa("12345678900", "João", "ABC-1234");
                Pessoa pessoa2 = new Pessoa("98765432100", "Gustavo","DEF-5678");
                Pessoa pessoa3 = new Pessoa("11122233344", "Otávio","GHI-9101");

                MySQLConnection.insertCarro(carro1);
                MySQLConnection.insertCarro(carro2);
                MySQLConnection.insertCarro(carro3);

                MySQLConnection.insertPessoa(pessoa1);
                MySQLConnection.insertPessoa(pessoa2);
                MySQLConnection.insertPessoa(pessoa3);

//                String query = "SELECT * FROM carro";
//                Statement stmt = connection.createStatement();
//                ResultSet rs = stmt.executeQuery(query);
//
//                while (rs.next()) {
//                    System.out.println("placa: " + rs.getString("placa"));
//                    // Manipule os resultados conforme necessário
//                }

//                rs.close();
//                stmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

