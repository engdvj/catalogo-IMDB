package br.com.adatech.projetos.catalogoIMDB.model;

import java.time.LocalDate;

/**
 * Classe que representa um Ator de filme
 * Contém construtores, parâmetros, além de getters e setters
 * @ModelPessoa - Classe abstrata mãe que possui atributos e métodos próprios
 */
public class ModelAtor extends ModelPessoa {
    private int quantidadeDePapel;
    private String tipoDePapel;

    public ModelAtor(String dados []) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
        this.tipoDePapel = "não definido";
    }

    public int getQuantidadeDePapel() {
        return quantidadeDePapel;
    }

    public void setQuantidadeDePapel(int quantidadeDePapel) {
        this.quantidadeDePapel = quantidadeDePapel;
    }

    public String getTipoDePapel() {
        return tipoDePapel;
    }

    public void setTipoDePapel(String tipoDePapel) {
        this.tipoDePapel = tipoDePapel;
    }

    @Override
    public String toString() {
        return "\n   Nome:" + nome + "'\'   Papel:" + tipoDePapel;
    }
}
