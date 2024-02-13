package br.com.adatech.projetos.catalogoIMDB.core;

import br.com.adatech.projetos.catalogoIMDB.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalogo {

    /**
     * Lista que armazena os filmes cadastrados no sistema.
     */

    private static ArrayList<ModelFilme> catalogo = new ArrayList<>();

    /**
     * Hashmap que armazena os roteristas e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do roteirista.
     */
    private static HashMap<ModelRoterista, List<ModelFilme>> mapRoteristasFilmes = new HashMap<>();

    public static HashMap<ModelRoterista, List<ModelFilme>> getRoteristas() {
        return mapRoteristasFilmes;
    }

    public static ArrayList<ModelFilme> getCatalogo() {
        return catalogo;
    }

    /**
     * Hashmap que armazena os diretores e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do diretor.
     */
    private static HashMap<ModelDiretor, List<ModelFilme>> mapDiretores = new HashMap<>();

    /**
     * Hashmap que armazena os atores e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do ator.
     */
    private static HashMap<ModelAtor, List<ModelFilme>> mapAtores = new HashMap<>();

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

