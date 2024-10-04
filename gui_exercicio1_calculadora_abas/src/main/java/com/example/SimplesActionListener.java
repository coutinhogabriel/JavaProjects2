package com.example;

import java.awt.event.ActionEvent;

public class SimplesActionListener implements ActionListenner {
    private double valorAtual;
    JPanel calcSimples = new CalculadoraSimples();

    @override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String operador;

        if (comando.matches("\\d")) {
            //composição dos números
            calcSimples.setDisplaySimples(calcSimples.getDisplaySimples() + comando);

            } else if (comando.matches("[+\\-*/]")){
                //seleção da operação
                valorAtual = Double.parseDouble(calcSimples.getDisplaySimples());
                operador = comando;
                displaySimples.setText("");
            }else if (comando.equals("=")){
                switch (operador) {
                    case value:
                        
                        break;
                
                    default:
                        break;
                }

    }
}}
