package org.example.jdbc.ex_prova;

public class Aluno {
    private int id;
    private String nome;
    private CpfSeguro cpf;
    private String endereco;
    private String turma;

    public Aluno() {
    }

    public Aluno(String nome, CpfSeguro cpf, String endereco, String turma) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.turma = turma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CpfSeguro getCpf() {
        return cpf;
    }

    public void setCpf(CpfSeguro cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
