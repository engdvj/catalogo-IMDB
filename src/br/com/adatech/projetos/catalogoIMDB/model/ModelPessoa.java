package br.com.adatech.projetos.catalogoIMDB.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Classe abstrata que representa uma Pessoa
 * Contém construtores, parâmetros, e métodos que serão herdados
 */
public abstract class ModelPessoa {

    protected String nome;
    protected String cpf;
    protected LocalDate dataDeNascimento;
    protected ArrayList<ModelFilme> participacoes = new ArrayList<>();

    public ModelPessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataNascimento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDeNascimento = LocalDate.parse(dataNascimento, formatter);
    }
    public abstract void novaParticipacao(Enum<?> variavel, ModelFilme filme);
    public abstract void removeParticipacao(Enum<?> papel, ModelFilme filme);
}
