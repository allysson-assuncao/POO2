package org.example.jdbc.ex_prova;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void salvar(Aluno aluno) throws SQLException, IOException {
        String sql = "INSERT INTO alunos (nome, cpf_objeto, endereco, turma) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());

            // 1. Serializando o objeto CPF para byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(aluno.getCpf());
            byte[] cpfBytes = baos.toByteArray();

            stmt.setBytes(2, cpfBytes); // Salva o array de bytes no banco
            stmt.setString(3, aluno.getEndereco());
            stmt.setString(4, aluno.getTurma());

            stmt.execute();
        }
    }

    public List<Aluno> listar() throws SQLException, IOException, ClassNotFoundException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));

                // 2. Desserializando o byte[] de volta para objeto CpfSeguro
                byte[] cpfBytes = rs.getBytes("cpf_objeto");
                if (cpfBytes != null) {
                    ByteArrayInputStream bais = new ByteArrayInputStream(cpfBytes);
                    ObjectInputStream ois = new ObjectInputStream(bais);
                    a.setCpf((CpfSeguro) ois.readObject());
                }

                a.setEndereco(rs.getString("endereco"));
                a.setTurma(rs.getString("turma"));
                alunos.add(a);
            }
        }
        return alunos;
    }
}
