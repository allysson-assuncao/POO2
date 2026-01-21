package org.example.serialização;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CadastroApp extends JFrame {

    // Componentes do formulário
    private JTextField txtCpf = new JTextField(15);
    private JTextField txtPrimeiroNome = new JTextField(20);
    private JTextField txtUltimoNome = new JTextField(20);
    private JTextField txtNascimento = new JTextField(10); // Formato dd/MM/yyyy
    private JTextField txtEndereco = new JTextField(30);
    private JTextField txtEmail = new JTextField(20);
    private JTextField txtTelefone = new JTextField(15);

    private static final String ARQUIVO_DADOS = "cadastro_pessoa.dat";

    public CadastroApp() {
        super("Cadastro de Pessoas - Serialização");
        configurarJanela();
        inicializarComponentes();

        // Tenta carregar dados existentes ao abrir a aplicação
        carregarDados();
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(8, 2, 10, 10));
        setLocationRelativeTo(null);

        // Ação de fechamento da janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salvarDados();
            }
        });
    }

    private void inicializarComponentes() {
        add(new JLabel("CPF:"));
        add(txtCpf);

        add(new JLabel("Primeiro Nome:"));
        add(txtPrimeiroNome);

        add(new JLabel("Último Nome:"));
        add(txtUltimoNome);

        add(new JLabel("Data Nasc. (dd/MM/yyyy):"));
        add(txtNascimento);

        add(new JLabel("Endereço:"));
        add(txtEndereco);

        add(new JLabel("Email:"));
        add(txtEmail);

        add(new JLabel("Telefone:"));
        add(txtTelefone);

        JButton btnSalvarManual = new JButton("Salvar Manualmente");
        btnSalvarManual.addActionListener(e -> salvarDados());
        add(btnSalvarManual);
    }

    // Lógica de Serialização (Escrita do Objeto)
    private void salvarDados() {
        // Validação simples do CPF antes de salvar
        if (!validarCPF(txtCpf.getText())) {
            JOptionPane.showMessageDialog(this, "CPF Inválido! Os dados não foram salvos.");
            return;
        }

        try {
            // Coleta dados do formulário
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNasc = LocalDate.parse(txtNascimento.getText(), formatter);

            Pessoa pessoa = new Pessoa(
                    txtCpf.getText(),
                    txtPrimeiroNome.getText(),
                    txtUltimoNome.getText(),
                    dataNasc,
                    txtEndereco.getText(),
                    txtEmail.getText(),
                    txtTelefone.getText()
            );

            // Uso do ObjectOutputStream para serializar o objeto no arquivo
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DADOS))) {
                out.writeObject(pessoa);
                System.out.println("Dados serializados com sucesso.");
            }

        } catch (DateTimeParseException dt) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + ex.getMessage());
        }
    }

    // Lógica de Desserialização (Leitura do Objeto)
    private void carregarDados() {
        File arquivo = new File(ARQUIVO_DADOS);
        if (!arquivo.exists()) return;

        // Uso do ObjectInputStream para reconstituir o objeto
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_DADOS))) {
            Pessoa pessoa = (Pessoa) in.readObject();
            preencherFormulario(pessoa);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Nenhum dado anterior encontrado ou erro ao ler: " + ex.getMessage());
        }
    }

    private void preencherFormulario(Pessoa p) {
        if (p == null) return;
        txtCpf.setText(p.getCpf());
        txtPrimeiroNome.setText(p.getPrimeiroNome());
        txtUltimoNome.setText(p.getUltimoNome());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (p.getDataNascimento() != null) {
            txtNascimento.setText(p.getDataNascimento().format(formatter));
        }

        txtEndereco.setText(p.getEndereco());
        txtEmail.setText(p.getEmail());
        txtTelefone.setText(p.getTelefone());
    }

    // Validação básica de CPF (formato)
    private boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        // Verifica se tem 11 dígitos (simplificação)
        return cpfLimpo.length() == 11;
    }

    public static void main(String[] args) {
        // Executa a aplicação na Thread de Eventos do Swing
        SwingUtilities.invokeLater(() -> {
            new CadastroApp().setVisible(true);
        });
    }
}
