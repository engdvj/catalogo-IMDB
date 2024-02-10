package br.com.adatech.projetos.catalogoIMDB.model;

import java.time.LocalDate;

/**
 * Classe que representa um Ator de filme
 * Contém construtores, parâmetros, além de getters e setters
 * @ModelPessoa - Classe abstrata mãe que possui atributos e métodos próprios
 */
public class ModelAtor extends ModelPessoa {
    int quantidadeDePapel;
    String tipodePapel;

    public ModelAtor(String nome, String cpf, LocalDate dataDeNascimento, int quantidadeDePapel, String tipodePapel) {
        super(nome, cpf, dataDeNascimento);
        this.quantidadeDePapel = quantidadeDePapel;
        this.tipodePapel = tipodePapel;
    }

    public int getQuantidadeDePapel() {
        return quantidadeDePapel;
    }

    public void setQuantidadeDePapel(int quantidadeDePapel) {
        this.quantidadeDePapel = quantidadeDePapel;
    }

    public String getTipodePapel() {
        return tipodePapel;
    }

    public void setTipodePapel(String tipodePapel) {
        this.tipodePapel = tipodePapel;
    }
}
