package br.com.adatech.projetos.catalogoIMDB.model;

import java.time.LocalDate;

/**
 * Classe que representa um Roteirista de filme
 * Contém construtores, parâmetros, além de getters e setters
 * @ModelPessoa - Classe abstrata mãe que possui atributos e métodos próprios
 */
public class ModelRoterista extends ModelPessoa {

    private int quantidadeDeRoteirosEscritos;
    private String area;

    public ModelRoterista(String nome, String cpf, LocalDate dataDeNascimento, int quantidadeDeRoteirosEscritos, String area) {
        super(nome, cpf, dataDeNascimento);
        this.quantidadeDeRoteirosEscritos = quantidadeDeRoteirosEscritos;
        this.area = area;
    }

    public int getQuantidadeDeRoteirosEscritos() {
        return quantidadeDeRoteirosEscritos;
    }

    public void setQuantidadeDeRoteirosEscritos(int quantidadeDeRoteirosEscritos) {
        this.quantidadeDeRoteirosEscritos = quantidadeDeRoteirosEscritos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return  "\n   Nome:" + nome +
                "\n   Area:" + area;
    }
}
