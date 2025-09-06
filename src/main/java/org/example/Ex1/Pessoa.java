package org.example.Ex1;

public abstract class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        validaPessoa(nome, idade);
        this.nome = nome;
        this.idade = idade;
    }

    public String getId() {
        return null;
    }

    protected void setId(String id) {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validaNome(nome);
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validaIdade(idade);
        this.idade = idade;
    }

    public void validaPessoa(String nome, int idade) {
        validaNome(nome);
        validaIdade(idade);
    }

    public void validaNome(String nome) {
        if (nome == null) {
            throw new RuntimeException("Nome nulo informado para a atualizacao! Ignorando...");
        }
    }

    public void validaIdade(int idade) {
        if (idade < 0) {
            throw new RuntimeException("Idade negativa informada para a atualizacao! Ignorando...");
        }
    }

}
