package org.example.jdbc.ex_prova;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private JTextField txtNome, txtCpf, txtEndereco, txtTurma;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private AlunoDAO dao;

    public TelaPrincipal() {
        dao = new AlunoDAO();
        setTitle("Gestão de Alunos - IFMG");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Cadastro
        JPanel painelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        painelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelForm.add(txtNome);

        painelForm.add(new JLabel("CPF (Será Serializado):"));
        txtCpf = new JTextField();
        painelForm.add(txtCpf);

        painelForm.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        painelForm.add(txtEndereco);

        painelForm.add(new JLabel("Turma:"));
        txtTurma = new JTextField();
        painelForm.add(txtTurma);

        JButton btnSalvar = new JButton("Salvar Aluno");
        btnSalvar.addActionListener(e -> salvarAluno());
        painelForm.add(btnSalvar);

        JButton btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.addActionListener(e -> carregarTabela());
        painelForm.add(btnAtualizar);

        add(painelForm, BorderLayout.NORTH);

        // Tabela
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Nome", "CPF (Objeto)", "Endereço", "Turma"}, 0);
        tabela = new JTable(modeloTabela);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Carrega dados iniciais
        carregarTabela();

        // Centraliza na tela (útil no seu Nobara/Linux)
        setLocationRelativeTo(null);
    }

    private void salvarAluno() {
        try {
            String nome = txtNome.getText();
            String cpfRaw = txtCpf.getText();
            String endereco = txtEndereco.getText();
            String turma = txtTurma.getText();

            // Encapsula o CPF no objeto serializável
            CpfSeguro cpfObj = new CpfSeguro(cpfRaw);

            Aluno aluno = new Aluno(nome, cpfObj, endereco, turma);
            dao.salvar(aluno);

            JOptionPane.showMessageDialog(this, "Aluno salvo com sucesso!");
            limparCampos();
            carregarTabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void carregarTabela() {
        modeloTabela.setRowCount(0); // Limpa tabela
        try {
            List<Aluno> lista = dao.listar();
            for (Aluno a : lista) {
                modeloTabela.addRow(new Object[]{
                        a.getId(),
                        a.getNome(),
                        a.getCpf().getValor(), // Extrai o valor do objeto recuperado
                        a.getEndereco(),
                        a.getTurma()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar: " + e.getMessage());
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtEndereco.setText("");
        txtTurma.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
