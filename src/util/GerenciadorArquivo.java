package util;

import model.Evento;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivo {

    private static final String ARQUIVO = "events.data";

    public static void salvarEventos(List<Evento> eventos) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {

            for (Evento e : eventos) {

                String linha = e.getNome() + ";" +
                        e.getEndereco() + ";" +
                        e.getCategoria() + ";" +
                        e.getDataHora().toString() + ";" + 
                        e.getDescricao();

                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos.");
        }
    }

    public static List<Evento> carregarEventos() {

        List<Evento> eventos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] dados = linha.split(";");

                Evento evento = new Evento(
                        dados[0],
                        dados[1],
                        dados[2],
                        LocalDateTime.parse(dados[3]), 
                        dados[4]
                );

                eventos.add(evento);
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe.");
        }

        return eventos;
    }
}