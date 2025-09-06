package org.example.Ex1;

import java.util.Scanner;

public class TestaPessoa {
    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Pessoa física ou juridica? (f/j)");
            boolean fisica = entrada.nextLine().equalsIgnoreCase("f");

            System.out.println("Digito o nome da pessoa: ");
            String nome = entrada.nextLine();

            System.out.println("Digito a idade da pessoa: ");
            int idade = entrada.nextInt();

            System.out.println("Digito o " + (fisica ? "cpf" : "cnpj") + " da pessoa: ");
            String id = entrada.nextLine();

            if (fisica) {
                try {
                    PessoaFisica pessoaFisica = new PessoaFisica(nome, idade, id);
                } catch (InvalidIDException idEx) {
                    System.err.println(idEx.getMessage());
                    System.out.println("Id informado incorretamente, repita o cadastro!");
                } catch (RuntimeException ex) {
                    System.err.println(ex.getMessage());
                    System.out.println("Dados da pessoa informados incorretamente, repita o cadastro!");
                }
            } else {
                try {
                    PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, idade, id);
                } catch (InvalidIDException idEx) {
                    System.err.println(idEx.getMessage());
                    System.out.println("Id informado incorretamente, repita o cadastro!");
                } catch (RuntimeException ex) {
                    System.err.println(ex.getMessage());
                    System.out.println("Dados da pessoa informados incorretamente, repita o cadastro!");
                }
            }
        System.out.println("Cadastro efetuado com sucesso!");
        }
    }
}
