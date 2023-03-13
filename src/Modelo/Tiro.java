package Modelo;

import javax.swing.*;
import java.awt.*;

public class Tiro {
    private Image imagem;
    private int x, y;
    private int largura, altura;
    private  boolean isVisivel;

    private static final int LARGURA = 938;
    private static  int VELOCIDADE = 4;

    public Tiro (int x, int y){
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    public void load(){
        ImageIcon referencia = new ImageIcon("res\\TiroSimples.png");
        imagem = referencia.getImage();

        this.largura = imagem.getHeight(null);
        this.altura = imagem.getWidth(null);
    }

    public void update() {
        this.x += VELOCIDADE;
        if (this.x > LARGURA){
            isVisivel = false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }


    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean visivel) {
        isVisivel = visivel;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        Tiro.VELOCIDADE = VELOCIDADE;
    }
}
