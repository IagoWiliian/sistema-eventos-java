package br.com.eventos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Eventos da Cidade ===");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Bem-vindo, " + nome + "!");

    }
}