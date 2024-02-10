package br.com.adatech.projetos.catalogoIMDB.model;

import java.time.Duration;
import java.time.LocalDate;

/**
 * Classe que representa um Filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelFilme {

    //Dei uma olhada no site do IMDb e esses são os principais parametros de filme, que aparecem no primeiro bloco. Teria os streaming tbm, mas achei sem necessidade

    String titulo;
    String descricao;
    String genero;
    int classificacaoIndicativa;
    LocalDate dataDeLancamento;
    Duration duracao;
    String direcao;
    String artistas;
    String roteiristas;
    double orcamento;
    double avaliacao;

    //Fiz um construtor geral, assim a medida que fomos sentido a necessidade podemos ir quebrando o construtor em menores.
    public ModelFilme(String titulo, String descricao, String genero, int classificacaoIndicativa, LocalDate dataDeLancamento, Duration duracao, String direcao, String artistas, String roteiristas, double orcamento, double avaliacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.dataDeLancamento = dataDeLancamento;
        this.duracao = duracao;
        this.direcao = direcao;
        this.artistas = artistas;
        this.roteiristas = roteiristas;
        this.orcamento = orcamento;
        this.avaliacao = avaliacao;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
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

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public String getRoteiristas() {
        return roteiristas;
    }

    public void setRoteiristas(String roteiristas) {
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
