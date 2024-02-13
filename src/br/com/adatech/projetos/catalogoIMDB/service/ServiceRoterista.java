package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;
import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;
import br.com.adatech.projetos.catalogoIMDB.model.ModelRoterista;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


/**
 * Classe que gerencia as operações relacionadas a roteristas no sistema de catálogo de filmes.
 * Esta classe oferece funcionalidades para adicionar, editar, remover e listar roteristas,
 */
public class ServiceRoterista {

    /**
     * Adiciona um roterista ao sistema.
     */
    public static void adicionarRoterista() {
        String dados[] = new String [3];
        System.out.println("Informe o nome:");
        dados[0] = Menu.sc.nextLine();
        System.out.println("Informe o CPF:");
        dados[1] = Menu.sc.nextLine();
        System.out.println("Informe a data de nascimento:");
        dados[2] = Menu.sc.nextLine();
        ModelRoterista roterista = new ModelRoterista(dados);
        Catalogo.getRoteristas().put(roterista,Catalogo.getCatalogo());
        System.out.println("Roterista "+ roterista.getNome() + " Cadastrado");
    }

    /**
     * Edita os detalhes de um roterista existente no sistema.
     *
     * @param roterista O objeto ModelRoterista com as informações atualizadas.
     */
    public void editarRoterista(ModelRoterista roterista) {}

    /**
     * Remove um roterista do sistema.
     *
     * @param roterista O objeto ModelRoterista a ser removido.
     */
    public static void removerRoterista(ModelRoterista roterista) {
        Catalogo.getRoteristas().remove(roterista,Catalogo.getCatalogo());
        System.out.println("Roteirista Removido!");
    }

    /**
     * Lista todos os roteristas cadastrados no sistema.
     */
    public static void listarRoteristas() {
        int i=1;
    for(HashMap.Entry<ModelRoterista, List<ModelFilme>> roterista:Catalogo.getRoteristas().entrySet()){
        System.out.print("Roteirista " + i + " - ");
        System.out.print(roterista.getKey().getNome() + "\n");
        i++;
        }
    }

    /**
     * Fornece os dados de um roterista específico.
     */
    public static void exibirDadosRoterista() {
        System.out.println("Digite o nome do roterista:");
        String nome = Menu.sc.nextLine();
        System.out.println(getRoteristaByName(nome));
    }

    public static ModelRoterista getRoteristaByName(String nome){
        try {
            for(Map.Entry<ModelRoterista, List<ModelFilme>> roterista: Catalogo.getRoteristas().entrySet()){
                if(roterista.getKey().getNome().equals(nome)){
                    return roterista.getKey();
                }
            }
            throw new NoSuchElementException("Roterista com o nome '" + nome + "' não encontrado.");
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }


}