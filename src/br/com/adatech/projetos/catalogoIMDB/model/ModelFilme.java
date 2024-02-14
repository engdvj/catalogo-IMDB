package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.ClassificacaoIndicativa;
import br.com.adatech.projetos.catalogoIMDB.util.Util.Genero;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe que representa um Filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelFilme {

    //Dei uma olhada no site do IMDb e esses são os principais parametros de filme que aparecem
    // no primeiro bloco. Teria os streaming tbm, mas achei sem necessidade.
    private String titulo;
    private String descricao;
    private Genero genero;
    private ClassificacaoIndicativa classificacaoIndicativa;
    private LocalDate dataDeLancamento;
    private Duration duracao;
    private ModelDiretor diretor;
    private ArrayList<ModelAtor> artistas = new ArrayList<>();
    private ArrayList<ModelRoterista> roteiristas = new ArrayList<>();
    private double orcamento;
    private double avaliacao;

    public ModelFilme(String titulo, Genero genero, ClassificacaoIndicativa ci) {
        this.titulo = titulo;
        this.genero = genero;
        this.classificacaoIndicativa = ci;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "titulo:'" + titulo +
                "\n descricao:'" + descricao +
                "\n genero:" + genero +
                "\n classificacaoIndicativa:" + classificacaoIndicativa +
                "\n dataDeLancamento:" + dataDeLancamento +
                "\n duracao:" + duracao +
                "\n direcao:" + diretor +
                "\n artistas:" + artistas +
                "\n roteiristas:" + roteiristas +
                "\n orcamento:" + orcamento +
                "\n avaliacao:" + avaliacao +
                '}';
    }

}
