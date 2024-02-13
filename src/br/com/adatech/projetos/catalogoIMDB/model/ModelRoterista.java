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

    public ModelRoterista(String dados []) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
        this.area = "não atribuída";
    }

    public int getQuantidadeDeRoteirosEscritos() {
        return quantidadeDeRoteirosEscritos;
    }

    public void novoRoteiroEscrito() { this.quantidadeDeRoteirosEscritos++; }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "\nDADOS PESSOAIS\n" +
                "\nNome: " + nome +
                "\nCPF: " + cpf +
                "\nDN: " + dataDeNascimento +

                "\n\nPARTICIPAÇÕES:";

    }
}
