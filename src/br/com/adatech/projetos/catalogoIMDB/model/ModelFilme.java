package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.Genero;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe que representa um Filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelFilme {

    //Dei uma olhada no site do IMDb e esses são os principais parametros de filme, que aparecem no primeiro bloco. Teria os streaming tbm, mas achei sem necessidade

    private String titulo;
    private String descricao;
    private Genero genero;
    private int classificacaoIndicativa;
    private LocalDate dataDeLancamento;
    private Duration duracao;
    private ModelDiretor direcao;
    private ArrayList<ModelAtor> artistas;
    private ArrayList<ModelRoterista> roteiristas;
    private double orcamento;
    private double avaliacao;

    public ModelFilme(String titulo, ModelDiretor direcao, ArrayList<ModelAtor> artistas, ArrayList<ModelRoterista> roteiristas) {
        this.titulo = titulo;
        this.direcao = direcao;
        this.artistas = artistas;
        this.roteiristas = roteiristas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public ModelDiretor getDirecao() {
        return direcao;
    }

    public void setDirecao(ModelDiretor direcao) {
        this.direcao = direcao;
    }

    public ArrayList<ModelAtor> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<ModelAtor> artistas) {
        this.artistas = artistas;
    }

    public ArrayList<ModelRoterista> getRoteiristas() {
        return roteiristas;
    }

    public void setRoteiristas(ArrayList<ModelRoterista> roteiristas) {
        this.roteiristas = roteiristas;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
}
