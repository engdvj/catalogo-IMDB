package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.ModelDiretor;
import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;

import java.util.HashMap;
import java.util.List;

/**
 * Classe que gerencia as operações relacionadas a diretores no sistema de catálogo de filmes.
 * Esta classe oferece funcionalidades para adicionar, editar, remover e listar diretores,
 * além de associar e desassociar filmes cadastrados.
 */
public class ServiceDiretor {

    /**
     * Hashmap que armazena os diretores e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do diretor.
     */
    private static HashMap<String, List<ModelFilme>> diretoresMap = new HashMap<>();

    /**
     * Adiciona um diretor ao sistema.
     *
     * @param diretor O objeto ModelDiretor a ser adicionado.
     */
    public void adicionarDiretor(ModelDiretor diretor) {}

    /**
     * Edita os detalhes de um diretor existente no sistema.
     *
     * @param diretor O objeto ModelDiretor com as informações atualizadas.
     */
    public void editarDiretor(ModelDiretor diretor) {}

    /**
     * Remove um diretor do sistema.
     *
     * @param diretor O objeto ModelDiretor a ser removido.
     */
    public void removerDiretor(ModelDiretor diretor) {}

    /**
     * Lista todos os diretores cadastrados no sistema.
     */
    public void listarDiretores() {}

    /**
     * Fornece os dados de um diretor específico.
     *
     * @param diretor O objeto ModelDiretor cujos dados são necessários.
     */
    public void dadosDiretor(ModelDiretor diretor) {}

    /**
     * Associa um filme a um diretor.
     *
     * @param diretor O objeto ModelDiretor ao qual o filme será associado.
     * @param filme O objeto ModelFilme a ser associado ao diretor.
     */
    public void associarFilme(ModelDiretor diretor, ModelFilme filme) {}

    /**
     * Desassocia um filme de um diretor.
     *
     * @param diretor O objeto ModelDiretor do qual o filme será desassociado.
     * @param filme O objeto ModelFilme a ser desassociado do diretor.
     */
    public void desassociarFilme(ModelDiretor diretor, ModelFilme filme) {}
}