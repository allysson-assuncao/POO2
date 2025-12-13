package guiprototype;

import java.awt.Color;
import java.awt.Graphics;

public class Elipse implements Cloneable {
    private int x, y, largura, altura;
    private Color cor;

    public Elipse(int x, int y, int largura, int altura, Color cor) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.cor = cor;
    }

    public void desenhar(Graphics g) {
        g.setColor(cor);
        g.fillOval(x, y, largura, altura);
    }

    @Override
    public Elipse clone() {
        try {
            // cópia superficial da superclasse
            // Como usamos tipos primitivos (int) e imutáveis (Color), é suficiente.
            return (Elipse) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar a elipse", e);
        }
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setLargura(int largura) { this.largura = largura; }
    public void setAltura(int altura) { this.altura = altura; }
    public void setCor(Color cor) { this.cor = cor; }
}
