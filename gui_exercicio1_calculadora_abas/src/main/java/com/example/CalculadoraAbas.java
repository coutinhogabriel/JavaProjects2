package com.example;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class CalculadoraAbas extends JFrame {
    //atributos

    //construtor
    public CalculadoraAbas (){
        super("Calculadora Abas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);

        //adicionar os componentes
        JTabbedPane abas = new JTabbedPane();

        JPanel calcSimples = new CalculadoraSimples();
        abas.addTab("SIMPLES", calcSimples);

        JPanel calcAvancada = new CalculadoraAvancada();
        abas.addTab("AVANÇADA", calcAvancada);

        this.add (abas);

        this.setVisible(true);
        
    }
}
