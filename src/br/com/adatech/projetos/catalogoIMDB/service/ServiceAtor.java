package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;
import br.com.adatech.projetos.catalogoIMDB.model.ModelAtor;
import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que gerencia as operações relacionadas a atores no sistema de catálogo de filmes.
 * Esta classe oferece funcionalidades para adicionar, editar, remover e listar atores,
 * além de associar e desassociar filmes cadastrados.
 */
public class ServiceAtor {

    /**
     * Adiciona um ator ao sistema.
     */
    public static void adicionarAtor() {

        String[] dados = new String[3];

        System.out.print("Digite o nome do ator:");
        dados[0] = Menu.sc.nextLine();
        System.out.print("Digite o CPF do ator:");
        dados[1] = Menu.sc.nextLine();
        System.out.print("Digite a data de nascimento do ator (no formato YYYY-MM-DD):");
        dados[2] = Menu.sc.nextLine();
        ModelAtor ator = new ModelAtor(dados);

        Catalogo.getAtores().put(ator, Catalogo.getCatalogo());
        System.out.println("O ator " + ator.getNome() + " foi adicionado com sucesso!!\n");
    }

    /**
     * Edita os detalhes de um ator existente no sistema.
     */
    public static void editarAtor() {
        HashMap<ModelAtor, ArrayList<ModelFilme>> listaDeAtores = Catalogo.getAtores();
        System.out.println(listarNomesAtores());
        System.out.print("Digite o nome do ator que deseja editar: ");
        String nomeAtorEditar = Menu.sc.nextLine();

        // Busca o ator pelo nome fornecido
        ModelAtor atorParaEditar = null;
        for (ModelAtor ator : listaDeAtores.keySet()) {
            if (ator.getNome().equalsIgnoreCase(nomeAtorEditar)) {
                atorParaEditar = ator;
                break;
            }
        }

        if (atorParaEditar != null) {
            System.out.println("O que deseja editar?");
            System.out.println("(1)- Nome" + "\n(2)- CPF" + "\n(3)- Data de Nascimento");
            System.out.print("->");

            int opcao = Menu.sc.nextInt();

            Menu.sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = Menu.sc.nextLine();
                    atorParaEditar.setNome(novoNome);
                    break;
                case 2:
                    System.out.print("Digite o novo CPF: ");
                    String novoCPF = Menu.sc.nextLine();
                    atorParaEditar.setCpf(novoCPF);
                    break;
                case 3:
                    System.out.print("Digite a nova data de nascimento (no formato YYYY-MM-DD): ");
                    String novaDataNascimento = Menu.sc.nextLine();
                    atorParaEditar.setDataDeNascimento(novaDataNascimento);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("As informações do ator foram atualizadas com sucesso!");
        } else {
            System.out.println("Ator não encontrado.");
        }
    }

    /**
     * Remove um ator do sistema.
     */
    public static void removerAtor() {
        HashMap<ModelAtor, ArrayList<ModelFilme>> listaDeAtores = Catalogo.getAtores();
        System.out.println(listarNomesAtores());
        System.out.print("Qual ator deseja remover? ");
        String atorParaRemover = Menu.sc.nextLine();

        listaDeAtores.keySet().removeIf(ator -> ator.getNome().equalsIgnoreCase(atorParaRemover));

        System.out.println("Ator " +atorParaRemover+ " removido com sucesso!");
    }

    /**
     * Lista todos os atores cadastrados no sistema.
     */
    public static void listarAtores() {
        if(!listarNomesAtores().isEmpty()){
        System.out.println(listarNomesAtores());
        }
    }


    /**
     * Fornece os dados de um ator específico.
     *
     */
    public static void dadosAtor() {
        HashMap<ModelAtor, ArrayList<ModelFilme>> listaDeAtores = Catalogo.getAtores();
        ModelAtor dadosAtor = null;
        System.out.println(listarNomesAtores());
        if (!listaDeAtores.isEmpty()) {
            System.out.print("Qual ator deseja pesquisar?");
            String nomeDoAtor = Menu.sc.nextLine();

            for (ModelAtor ator : listaDeAtores.keySet()) {
                if (ator.getNome().equalsIgnoreCase(nomeDoAtor)) {
                    dadosAtor = ator;
                    break;
                }
            }

            if (dadosAtor != null) {
                System.out.print("\nDetalhes do ator\n" +
                        "\nNome: " + dadosAtor.getNome() +
                        "\nCPF: " + dadosAtor.getCpf() +
                        "\nData de nascimento: " + dadosAtor.getDataDeNascimento() +
                        "\nQuantidade de papeis: " + dadosAtor.getQuantidadeDePapel() +
                        "\n\n"
                );
            } else {
                System.out.println("Ator não encontrado.");
            }
        }

    }


    public static String listarNomesAtores() {
        HashMap<ModelAtor, ArrayList<ModelFilme>> listaDeAtores = Catalogo.getAtores();
        StringBuilder nomesFormatados = new StringBuilder();

        if (!listaDeAtores.isEmpty()) {
            for (ModelAtor ator : listaDeAtores.keySet()) {
                nomesFormatados.append("-").append(ator.getNome()).append("\n");
            }
        } else {
            nomesFormatados.append("A lista de atores está vazia");
        }
        return nomesFormatados.toString();
    }

}