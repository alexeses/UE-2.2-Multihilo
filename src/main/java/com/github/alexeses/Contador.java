package com.github.alexeses;

import java.util.Scanner;

public class Contador {
    private int a, e, i, o, u;
    private String texto;

    public Contador(String texto) {
        this.texto = texto;
    }

    public void contarVocales() {
        a = 0;
        e = 0;
        i = 0;
        o = 0;
        u = 0;
        for (int j = 0; j < texto.length(); j++) {
            char c = texto.charAt(j);
            if (c == 'a' || c == 'A') {
                a++;
            }
            if (c == 'e' || c == 'E') {
                e++;
            }
            if (c == 'i' || c == 'I') {
                i++;
            }
            if (c == 'o' || c == 'O') {
                o++;
            }
            if (c == 'u' || c == 'U') {
                u++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el texto: ");
        String texto = sc.nextLine();
        Contador contador = new Contador(texto);
        Thread hiloA = new Thread(() -> {
            contador.contarVocales();
            System.out.println("A: " + contador.a);
        });
        Thread hiloE = new Thread(() -> {
            contador.contarVocales();
            System.out.println("E: " + contador.e);
        });
        Thread hiloI = new Thread(() -> {
            contador.contarVocales();
            System.out.println("I: " + contador.i);
        });
        Thread hiloO = new Thread(() -> {
            contador.contarVocales();
            System.out.println("O: " + contador.o);
        });
        Thread hiloU = new Thread(() -> {
            contador.contarVocales();
            System.out.println("U: " + contador.u);
        });
        hiloA.start();
        hiloE.start();
        hiloI.start();
        hiloO.start();
        hiloU.start();
    }
}
