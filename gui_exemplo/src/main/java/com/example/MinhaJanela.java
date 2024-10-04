package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MinhaJanela extends JFrame {
    public MinhaJanela() {
        super("Minha Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);

        JPanel painel = new JPanel();
        this.add(painel);

        // Adiciona um JButton (botão)
        JButton botao = new JButton("Clique aqui");
        painel.add(botao);
    //    botao.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             JOptionPane.showMessageDialog(null, "Botão clicado!");
    //         }
    //     });

        //adicionar evento no botão
        botao.addActionListener(e->{
            JOptionPane.showMessageDialog(null, "Botão clicado!");
        });
         this.setVisible(true);
    }

   
}
