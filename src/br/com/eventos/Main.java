package br.com.eventos;

import service.SistemaEventos;

import java.util.Scanner;
import service.SistemaEventos;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SistemaEventos sistema = new SistemaEventos();

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE EVENTOS ===");
            System.out.println("1 - Cadastrar evento");
            System.out.println("2 - Listar eventos");
            System.out.println("3 - Participar de evento");
            System.out.println("4 - Cancelar participação");
            System.out.println("5 - Meus eventos");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    sistema.cadastrarEvento(scanner);
                    break;
                case 2:
                    sistema.listarEventos();
                    break;
                case 3:
                    sistema.participarEvento(scanner);
                    break;
                case 4:
                    sistema.cancelarParticipacao(scanner);
                    break;
                case 5:
                    sistema.meusEventos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}