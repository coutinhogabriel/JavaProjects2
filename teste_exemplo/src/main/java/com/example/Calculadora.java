package com.example;

public class Calculadora {
    //soma
    public double soma(double a, double b){
        return a + b;
    }
    //subtração
    public double subtracao(double a, double b){
        return a - b;
    }
    //multiplicação
    public double multiplicacao(double a, double b){
        return a * b;
    }
    //divisão
    public double divisao(double a, double b){
        if (b == 0) {
            throw new IllegalArgumentException("Não dividirás por Zero");
        }
        return a / b;
    }
}
