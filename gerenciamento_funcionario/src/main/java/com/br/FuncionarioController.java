package com.br;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();

    }

    // método add
    public void addFuncionario() {
        // criar funcionari
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario"));
        Funcionario funcionario = new Funcionario(nome, idade, salario);
        funcionarios.add(funcionario);
    }

    // métodos listar todos os funcionarios
    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }

    // métodos buscar um funcionario pelo nome
    public void buscarFuncionario() {
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario");

        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    System.out.println(funcionario.toString());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionario não encontrado");

            }
        } catch (Exception e) {
            System.out.println();
        }

    }

    // métodos remover um funcionario pelo nome
    public void removerFuncionario() {
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario a ser removido");

        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    funcionarios.remove(funcionario);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionario removido com sucesso");

            }
        } catch (Exception e) {
            System.out.println();
        }

    }

    // métodos de media salarial

    public void calculoMediaSalario() {
        double mediaSalarios = 0;
        if (funcionarios.size() == 0) {
            System.out.println("Lista Vazia");

        } else {
            for (Funcionario funcionario : funcionarios) {
                mediaSalarios += funcionario.getSalario();
            }
            mediaSalarios /= funcionarios.size();
            System.out.println("A média de salarios é: " + mediaSalarios);
        }

    }

}
