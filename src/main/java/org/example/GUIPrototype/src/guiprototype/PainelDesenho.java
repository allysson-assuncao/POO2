package guiprototype;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class PainelDesenho extends javax.swing.JPanel {

    public PainelDesenho() {
        initComponents();
    }
    
    // Lista que armazena todas as elipses a serem desenhadas
    private List<Elipse> elipses = new ArrayList<>();

    // Adiciona uma nova elipse e solicita a repintura do painel
    public void adicionarElipse(Elipse e) {
        elipses.add(e);
        repaint(); // Força o Swing a chamar o paintComponent novamente
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpa o painel antes de redesenhar
        
        // Percorre a lista e pede para cada elipse se desenhar
        for (Elipse e : elipses) {
            e.desenhar(g);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
