package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.ModelDiretor;
import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;
import br.com.adatech.projetos.catalogoIMDB.model.ModelPessoa;

import java.util.ArrayList;


/**
 * Classe que representa as operações realizadas por um objeto da classe Filme
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class ServiceFilme {

//    public ArrayList<ModelFilme> filmes = new ArrayList<>();

    /**
     * Adiciona um filme ao sistema.
     *
     * @param filme O objeto ModelFilme a ser adicionado.
     */
    public void adicionarFilme(ModelFilme filme) {}

    /**
     * Edita os detalhes de um filme existente no sistema.
     *
     * @param filme O objeto ModelFilme com as informações atualizadas.
     */
    public void editarFilme(ModelFilme filme) {}

    /**
     * Remove um diretor do sistema.
     *
     * @param filme O objeto ModelFilme a ser removido.
     */
    public void removerFilme(ModelFilme filme) {}

    /**
     * Lista todos os filmes cadastrados no sistema.
     */
    public void listarFilmes() {}

    /**
     * Fornece os dados de um diretor específico.
     *
     * @param filme O objeto ModelFilme cujos dados são necessários.
     */
    public void fichaTecnica(ModelFilme filme) {}

    /**
     * Associa uma pessoa a um filme.
     *
     * @param pessoa O objeto ModelPessoa ao qual o filme será associado.
     * @param filme O objeto ModelFilme a ser associado ao diretor.
     */
    public void associarFilme(ModelPessoa pessoa, ModelFilme filme) {}

    /**
     * Desassocia uma pessoa de um filme.
     *
     * @param pessoa O objeto ModelPessoa do qual o filme será desassociado.
     * @param filme O objeto ModelFilme a ser desassociado do diretor.
     */
    public void desassociarFilme(ModelPessoa pessoa, ModelFilme filme) {}

}
