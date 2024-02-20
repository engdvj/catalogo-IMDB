package br.com.adatech.projetos.catalogoIMDB.core;

import br.com.adatech.projetos.catalogoIMDB.model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo {

    /**
     * Lista que armazena os filmes cadastrados no sistema.
     */

    private static ArrayList<ModelFilme> catalogo = new ArrayList<>();

    /**
     * Hashmap que armazena os roteristas e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do roteirista.
     */
    private static HashMap<ModelRoterista, ArrayList<ModelFilme>> mapRoteristasFilmes = new HashMap<>();

    public static HashMap<ModelRoterista, ArrayList<ModelFilme>> getRoteristas() {
        return mapRoteristasFilmes;
    }


    public static ArrayList<ModelFilme> getCatalogo() {
        return catalogo;
    }

    /**
     * Hashmap que armazena os diretores e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do diretor.
     */
    private static HashMap<ModelDiretor, ArrayList<ModelFilme>> mapDiretores = new HashMap<>();
    public static HashMap<ModelDiretor, ArrayList<ModelFilme>> getDiretores() {
        return mapDiretores;
    }
    /**
     * Hashmap que armazena os atores e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do ator.
     */
    private static HashMap<ModelAtor, ArrayList<ModelFilme>> mapAtores = new HashMap<>();

    public static HashMap<ModelAtor, ArrayList<ModelFilme>> getAtores() {
        return mapAtores;
    }

    /**
     * Associa uma pessoa a um filme.
     *
     * @param pessoa O objeto ModelPessoa ao qual o filme será associado.
     * @param filme  O objeto ModelFilme a ser associado ao diretor.
     */
    public void associarFilme(ModelPessoa pessoa, ModelFilme filme) {
    }

    /**
     * Desassocia uma pessoa de um filme.
     *
     * @param pessoa O objeto ModelPessoa do qual o filme será desassociado.
     * @param filme  O objeto ModelFilme a ser desassociado do diretor.
     */
    public void desassociarFilme(ModelPessoa pessoa, ModelFilme filme) {
    }
}

