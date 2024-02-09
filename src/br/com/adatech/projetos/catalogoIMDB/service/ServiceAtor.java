package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.ModelAtor;
import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;

import java.util.HashMap;
import java.util.List;

/**
 * Classe que gerencia as operações relacionadas a atores no sistema de catálogo de filmes.
 * Esta classe oferece funcionalidades para adicionar, editar, remover e listar atores,
 * além de associar e desassociar filmes cadastrados.
 */
public class ServiceAtor {

    /**
     * Hashmap que armazena os atores e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do diretor.
     */
    private static HashMap<String, List<ModelFilme>> atoresMap = new HashMap<>();

    /**
     * Adiciona um ator ao sistema.
     *
     * @param ator O objeto ModelDiretor a ser adicionado.
     */
    public void adicionarAtor(ModelAtor ator) {}

    /**
     * Edita os detalhes de um ator existente no sistema.
     *
     * @param ator O objeto ModelDiretor com as informações atualizadas.
     */
    public void editarAtor(ModelAtor ator) {}

    /**
     * Remove um ator do sistema.
     *
     * @param ator O objeto ModelAtor a ser removido.
     */
    public void removerAtor(ModelAtor ator) {}

    /**
     * Lista todos os atores cadastrados no sistema.
     */
    public void listarAtores() {}

    /**
     * Fornece os dados de um ator específico.
     *
     * @param ator O objeto ModelDiretor cujos dados são necessários.
     */
    public void dadosAtor(ModelAtor ator) {}

    /**
     * Associa um filme a um diretor.
     *
     * @param ator O objeto ModelDiretor ao qual o filme será associado.
     * @param filme O objeto ModelFilme a ser associado ao diretor.
     */
    public void associarFilme(ModelAtor ator, ModelFilme filme) {}

    /**
     * Desassocia um filme de um diretor.
     *
     * @param ator O objeto ModelDiretor do qual o filme será desassociado.
     * @param filme O objeto ModelFilme a ser desassociado do diretor.
     */
    public void desassociarFilme(ModelAtor ator, ModelFilme filme) {}
}
