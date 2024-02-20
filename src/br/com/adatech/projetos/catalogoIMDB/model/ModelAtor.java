package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.*;

import java.util.ArrayList;


/**
 * Classe que representa um Ator de filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelAtor extends ModelPessoa {
    private int quantidadeDePapel;
    private ArrayList<PapelAtor> area = new ArrayList<>();
    private ArrayList<ModelFilme> participacoes = new ArrayList<>();

    public ModelAtor(String [] dados) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
        area.add(PapelAtor.INDEFINIDO);
    }

    public int getQuantidadeDePapel() {
        return quantidadeDePapel;
    }

    public void novoPapel(PapelAtor papelAtor) {
        quantidadeDePapel++;
        area.add(papelAtor);
    }
    public ArrayList<PapelAtor> getPapelAtor() {
        return area;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nCPF: "+ cpf + "\nData de nascimento: "+dataDeNascimento+"\nPapel: " + quantidadeDePapel +"\n" ;  }
}
