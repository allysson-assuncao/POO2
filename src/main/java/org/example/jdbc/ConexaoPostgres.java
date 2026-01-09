package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoPostgres {

    private static final String URL = "jdbc:postgresql://10.90.24.54:5432/aula";
    private static final String USUARIO = "aula";
    private static final String SENHA = "aula";

    public static void main(String[] args) {

        System.out.println("--- Iniciando Tentativa de Conexão ---");

        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {

            if (conexao != null) {
                System.out.println("✅ Conexão estabelecida com sucesso!");
                System.out.println("Conectado ao esquema: " + conexao.getSchema());

                lerVersaoDoBanco(conexao);
            } else {
                System.out.println("❌ Falha ao estabelecer conexão.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro de SQL/Conexão:");
            e.printStackTrace();
        }
    }

    private static void lerVersaoDoBanco(Connection conexao) throws SQLException {
        String sql = "SELECT version()";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                String versao = rs.getString(1);
                System.out.println("\n📊 Versão do PostgreSQL Remoto:");
                System.out.println(versao);
            }
        }
    }
}
