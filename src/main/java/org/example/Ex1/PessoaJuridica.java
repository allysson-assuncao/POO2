package org.example.Ex1;

public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica(String nome, int idade, String cnpj) {
        super(nome, idade);
        validaCNPJ(cnpj);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        validaCNPJ(cnpj);
        this.cnpj = cnpj;
    }

    protected void setId(String id) {
        setCnpj(id);
    }

    public void validaCNPJ(String cnpj) {
        if (cnpj == null) {
            throw new RuntimeException("CNPJ nulo informado para a atualizacao! Ignorando...");
        }
    }

}
