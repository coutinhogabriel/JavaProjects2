package com.br;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FuncionarioController gerenciaFuncionario = new FuncionarioController();
        int operacao =0;
        do{
            operacao = Integer.parseInt(JOptionPane.showInputDialog(
                "\nGerenciamento de Funcionarios\n"
                    + "1- Adicionar Funcionarios\n"
                    + "2- Listar Funcionarios\n"
                    + "3- Buscar Funcionario\n"
                    + "4- Remover Funcionario\n"
                    + "5- Média Salarial\n"
                    + "6- Sair\n"));

            switch(operacao){
                case 1:
                    gerenciaFuncionario.addFuncionario();
                    break;
                case 2:
                    gerenciaFuncionario.listarFuncionarios();
                    break;
                case 3:
                    gerenciaFuncionario.buscarFuncionario();
                    break;
                case 4:
                    gerenciaFuncionario.removerFuncionario();
                    break;
                case 5:
                    gerenciaFuncionario.calculoMediaSalario();
                    break;
                case 6:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Insira uma operação válida!");
            }
                
        
                    
        }
        while (operacao!=6);

    }
}