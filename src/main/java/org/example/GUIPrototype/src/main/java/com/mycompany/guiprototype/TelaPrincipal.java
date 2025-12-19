package com.mycompany.guiprototype;

import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());
    private Elipse prototipoElipse;
    private Random random;
    
    public TelaPrincipal() {
        initComponents();
        random = new Random();
        
        // Configuração do Protótipo inicial (Padrão)
        // Criação da elipse molde azul
        prototipoElipse = new Elipse(0, 0, 50, 50, Color.BLUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDesenho = new com.mycompany.guiprototype.PainelDesenho();
        btnGerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelDesenho.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelDesenhoLayout = new javax.swing.GroupLayout(painelDesenho);
        painelDesenho.setLayout(painelDesenhoLayout);
        painelDesenhoLayout.setHorizontalGroup(
            painelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelDesenhoLayout.setVerticalGroup(
            painelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );

        btnGerar.setText("Gerar Elipse");
        btnGerar.addActionListener(this::btnGerarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGerar)
                        .addGap(0, 589, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        try {
            // 1. Clonagem do protótipo
            Elipse novaElipse = prototipoElipse.clone();
            
            // 2. Alteração do estado do clone (Randomização)
            
            // Posição aleatória dentro do painel
            int maxX = painelDesenho.getWidth();
            int maxY = painelDesenho.getHeight();
            novaElipse.setX(random.nextInt(maxX - 50));
            novaElipse.setY(random.nextInt(maxY - 50));
            
            // Dimensões aleatórias (entre 20 e 100px)
            novaElipse.setLargura(20 + random.nextInt(80));
            novaElipse.setAltura(20 + random.nextInt(80));
            
            // Cor aleatória
            Color corAleatoria = new Color(
                random.nextInt(256), // R
                random.nextInt(256), // G
                random.nextInt(256)  // B
            );
            novaElipse.setCor(corAleatoria);
            
            // 3. Adicionar ao painel e atualizar
            painelDesenho.adicionarElipse(novaElipse);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao clonar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGerarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private com.mycompany.guiprototype.PainelDesenho painelDesenho;
    // End of variables declaration//GEN-END:variables
}
