package org.example;

public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica(String nome, int idade, String cpf) {
        super(nome, idade);
        validaCPF(cpf);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validaCPF(cpf);
        this.cpf = cpf;
    }

    protected void setId(String id) {
        setCpf(id);
    }

    public void validaCPF(String cpf) {
        if (cpf == null) {
            throw new RuntimeException("CPF nulo informado para a atualizacao! Ignorando...");
        }
    }

}
