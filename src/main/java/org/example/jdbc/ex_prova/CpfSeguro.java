package org.example.jdbc.ex_prova;

import java.io.Serializable;

public class CpfSeguro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String valor;

    public CpfSeguro(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
