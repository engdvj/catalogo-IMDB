package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.ModelRoterista;
import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;

import java.util.HashMap;
import java.util.List;

/**
 * Classe que gerencia as operações relacionadas a roteristas no sistema de catálogo de filmes.
 * Esta classe oferece funcionalidades para adicionar, editar, remover e listar atores,
 * além de associar e desassociar filmes cadastrados.
 */
public class ServiceRoterista {

    /**
     * Adiciona um roterista ao sistema.
     *
     * @param roterista O objeto ModelAtor a ser adicionado.
     */
    public void adicionarRoterista(ModelRoterista roterista) {}

    /**
     * Edita os detalhes de um roterista existente no sistema.
     *
     * @param roterista O objeto ModelRoterista com as informações atualizadas.
     */
    public void editarAtor(ModelRoterista roterista) {}

    /**
     * Remove um roterista do sistema.
     *
     * @param roterista O objeto ModelRoterista a ser removido.
     */
    public void removerAtor(ModelRoterista roterista) {}

    /**
     * Lista todos os roteristas cadastrados no sistema.
     */
    public void listarRoteristas() {}

    /**
     * Fornece os dados de um roterista específico.
     *
     * @param roterista O objeto ModelRoterista cujos dados são necessários.
     */
    public void dadosAtor(ModelRoterista roterista) {}

}
