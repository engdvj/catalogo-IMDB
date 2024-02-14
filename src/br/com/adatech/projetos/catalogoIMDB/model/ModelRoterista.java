package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.AreaRoteirista;

import java.util.ArrayList;

/**
 * Classe que representa um Roteirista de filme
 * Contém construtores, parâmetros, além de getters e setters
 * @ModelPessoa - Classe abstrata mãe que possui atributos e métodos próprios
 */
public class ModelRoterista extends ModelPessoa {

    private int quantidadeDeRoteirosEscritos;
    private ArrayList<AreaRoteirista> area = new ArrayList<>();

    public ModelRoterista(String dados []) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
        area.add(AreaRoteirista.INDEFINIDO);
    }

    public int getQuantidadeDeRoteirosEscritos() {
        return quantidadeDeRoteirosEscritos;
    }

    public void novoRoteiroEscrito() { this.quantidadeDeRoteirosEscritos++; }

    @Override
    public String toString() {
        return "\nDADOS PESSOAIS\n" +
                "\nNome: " + nome +
                "\nCPF: " + cpf +
                "\nDN: " + dataDeNascimento +

                "\n\nPARTICIPAÇÕES:";

    }
}
