package com.example;

import java.util.Scanner;

public class Exercicio01 {
    //atributos
    double [] notas = new double[4]; 
    double media = 0;
    boolean bonus = false;

    //métodos
    public void calculoMedia() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Digite a nota "+ (i+1) +":");
            notas [i] = sc.nextDouble();
            media+=notas[i];
        }
        media = media/notas.length;

        //verificar bonus
        if (notas[0]>=9 && notas[1]>=9 && notas[2]>=9 && notas[3]>=9) {
            media = media*1.1;
            bonus = true;
            //se média for maior que 10 
        }if (bonus) {
            System.out.println("Contemplado com bonus de 10%");
        }

        if(media>7){
            System.out.println("A média do aluno é %.2f"+ media + "Aprovado");
        }else if(media>=5 && media<7) {
            System.out.println("A média do aluno é %.2f"+ media + "Recuperação");
        }else{
            System.out.println("A média do aluno é %.2f"+ media + "Reprovado");
        }
     }
}
