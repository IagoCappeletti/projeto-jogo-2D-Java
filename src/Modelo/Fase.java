package Modelo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;


import javax.swing.*;

public class Fase extends JPanel implements ActionListener {

    private final Image fundo;
    private final Player player;
    public Timer timer;

    public Fase () {

        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("res\\Background.png");
        fundo = referencia.getImage();

        player = new Player();
        player.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(10, this);
        timer.start();
    }

    public void paint (Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(player.getImagem(), player.getX(),player.getY(),this);

        List<Tiro> tiros = player.getTiros();
        for (Tiro m : tiros) {
            m.load();
            graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {  //Metodo que atualiza os movimentos da nave na tela
        player.update();

        List<Tiro> tiros = player.getTiros();
        for (int i = 0; i < tiros.size(); i++){
            Tiro m = tiros.get(i);
            if (m.isVisivel()){
                m.update();
            } else {
                tiros.remove(i);
            }
        }

        repaint();
    }

    private class TecladoAdapter extends KeyAdapter { //Metodo de entrada no telcado
        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e){
            player.keyRelease(e);
        }
    }
}
