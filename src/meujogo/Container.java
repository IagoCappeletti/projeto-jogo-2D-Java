package meujogo;

import javax.swing.JFrame;

import Modelo.Fase;

public class Container extends JFrame{

    public  Container () {
        add(new Fase());
        setTitle("Meu jogo");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para fechar o jogo no X
        setLocationRelativeTo(null);
        this.setResizable(false); //Para permitir o usuário deixar em full screen
        setVisible(true); //Permite que os comando a cima sejam visiveis
    }

    public static void main (String[] args){
        new Container();
    }
}

