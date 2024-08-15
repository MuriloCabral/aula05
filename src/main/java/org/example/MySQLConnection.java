package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/facul"; // Substitua por sua URL de conexão
    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao MySQL: " + e.getMessage());
        }
        return connection;
    }

    public static void insertCarro(Carros carro) {
        String query = "INSERT INTO carro (placa, modelo, cor, ano) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setInt(4, carro.getAno());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir carro: " + e.getMessage());
        }
    }

    public static void insertPessoa(Pessoa pessoa) {
        String query = "INSERT INTO pessoa (cpf, nome, placa) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setString(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getPlaca());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }
}
