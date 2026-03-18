package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Evento {

    private String id;
    private String nome;
    private String endereco;
    private String categoria;
    private LocalDateTime dataHora;
    private String descricao;

    public Evento(String nome, String endereco, String categoria, LocalDateTime dataHora, String descricao) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    

    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public LocalDateTime getDataHora() {
		return dataHora;
	}



	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	@Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "\nID: " + id.substring(0, 8) +
                "\nEvento: " + nome +
                "\nEndereço: " + endereco +
                "\nCategoria: " + categoria +
                "\nData: " + dataHora.format(formatter) +
                "\nDescrição: " + descricao +
                "\n------------------------";
    }
}