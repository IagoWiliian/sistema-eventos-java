package service;

import model.Evento;
import util.GerenciadorArquivo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SistemaEventos {

    private List<Evento> eventos;
    private List<Evento> meusEventos = new ArrayList<>();

    
    public SistemaEventos() {
        eventos = GerenciadorArquivo.carregarEventos();
    }

    public void cadastrarEvento(Scanner scanner) {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Data (dd/MM/yyyy HH:mm): ");
        String data = scanner.nextLine();

        LocalDateTime horario;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            horario = LocalDateTime.parse(data, formatter);
        } catch (Exception e) {
            System.out.println("Formato inválido!");
            return;
        }

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Evento evento = new Evento(nome, endereco, categoria, horario, descricao);
        eventos.add(evento);

        
        GerenciadorArquivo.salvarEventos(eventos);

        System.out.println("Evento criado com ID: " + evento.getId().substring(0, 8));
    }

    public void listarEventos() {

        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        eventos.sort(Comparator.comparing(Evento::getDataHora));

        System.out.println("\n=== EVENTOS ===");

        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    public void participarEvento(Scanner scanner) {

        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento disponível.");
            return;
        }

        listarEventos();

        System.out.print("Digite o ID do evento: ");
        String id = scanner.nextLine();

        for (Evento e : eventos) {
            if (e.getId().startsWith(id)) {

                if (meusEventos.contains(e)) {
                    System.out.println("Você já participa desse evento.");
                    return;
                }

                meusEventos.add(e);
                System.out.println("Participação confirmada!");
                return;
            }
        }

        System.out.println("Evento não encontrado.");
    }

    public void cancelarParticipacao(Scanner scanner) {

        if (meusEventos.isEmpty()) {
            System.out.println("Nenhum evento para cancelar.");
            return;
        }

        System.out.println("\n=== MEUS EVENTOS ===");

        for (Evento e : meusEventos) {
            System.out.println(e);
        }

        System.out.print("Digite o ID do evento: ");
        String id = scanner.nextLine();

        Iterator<Evento> iterator = meusEventos.iterator();

        while (iterator.hasNext()) {
            Evento e = iterator.next();

            if (e.getId().startsWith(id)) {
                iterator.remove();

                
                GerenciadorArquivo.salvarEventos(eventos);

                System.out.println("Cancelado com sucesso!");
                return;
            }
        }

        System.out.println("Evento não encontrado.");
    }

    public void meusEventos() {

        if (meusEventos.isEmpty()) {
            System.out.println("Você não está em nenhum evento.");
            return;
        }

        System.out.println("\n=== MEUS EVENTOS ===");

        for (Evento e : meusEventos) {
            System.out.println(e);
        }
    }
}