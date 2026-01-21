package org.example.serialização;

import java.io.Serializable;
import java.time.LocalDate;

// Implementa Serializable para permitir a persistência
public class Pessoa implements Serializable {
    // Serial Version UID para garantir compatibilidade durante a desserialização
    private static final long serialVersionUID = 1L;

    private String cpf;
    private String primeiroNome;
    private String ultimoNome;
    private LocalDate dataNascimento;
    private String endereco;
    private String email;
    private String telefone;

    public Pessoa(String cpf, String primeiroNome, String ultimoNome, LocalDate dataNascimento,
                  String endereco, String email, String telefone) {
        this.cpf = cpf;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public String getCpf() { return cpf; }
    public String getPrimeiroNome() { return primeiroNome; }
    public String getUltimoNome() { return ultimoNome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEndereco() { return endereco; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return primeiroNome + " " + ultimoNome;
    }
}
