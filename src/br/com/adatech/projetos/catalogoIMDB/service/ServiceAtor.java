package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;
import br.com.adatech.projetos.catalogoIMDB.model.*;
import br.com.adatech.projetos.catalogoIMDB.util.Util;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

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
        System.out.print("Digite o nome completo:");
        dados[0] = Menu.sc.nextLine();
        System.out.print("Digite o CPF:");
        dados[1] = Util.validarCPF();
        System.out.println("Digite a data de nascimento (formato DD/MM/YYYY):");
        dados[2] = Util.validarData();
        ModelAtor ator = new ModelAtor(dados);

        Catalogo.getCatalogoAtores().add(ator);
        System.out.println("O ator " + ator.getNome() + " foi adicionado com sucesso!!\n");
    }

    /**
     * Edita os detalhes de um ator existente no sistema.
     */
    public static void editarAtor() {
        ArrayList<ModelAtor> listaDeAtores = Catalogo.getCatalogoAtores();
        System.out.println(listarNomesAtores());
        System.out.print("Digite o nome do ator que gostaria de alterar: ");
        String nomeAtorEditar = Menu.sc.nextLine();

        // Busca o ator pelo nome fornecido
        ModelAtor atorParaEditar = null;
        for (ModelAtor ator : listaDeAtores) {
            if (ator.getNome().equalsIgnoreCase(nomeAtorEditar)) {
                atorParaEditar = ator;
                break;
            }
        }

        if (atorParaEditar != null) {
            System.out.println("Qual informação gostaria de editar?");
            System.out.println("""
                    (1)- Nome
                    (2)- CPF
                    (3)- Data de Nascimento""");
            System.out.print("->");
            int opcao = Menu.sc.nextInt();
            Menu.sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = Menu.sc.nextLine();
                    atorParaEditar.setNome(novoNome);
                    System.out.println("Nome alterado!");
                    break;
                case 2:
                    System.out.print("Digite o novo CPF: ");
                    String novoCPF = Util.validarCPF();
                    atorParaEditar.setCpf(novoCPF);
                    System.out.println("CPF alterado!");
                    break;
                case 3:
                    System.out.print("Digite a nova data de nascimento (no formato YYYY-MM-DD): ");
                    String novaDataNascimento = Util.validarData();
                    atorParaEditar.setDataDeNascimento(novaDataNascimento);
                    System.out.println("Data de nascimento alterada!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Ator não encontrado.");
        }
    }

    /**
     * Remove um ator do sistema.
     */
    public static void removerAtor() {
        ArrayList<ModelAtor> listaDeAtores = Catalogo.getCatalogoAtores();
        System.out.println(listarNomesAtores());
        System.out.print("Qual ator deseja remover? ");
        String atorParaRemover = Menu.sc.nextLine();

        listaDeAtores.removeIf(ator -> ator.getNome().equalsIgnoreCase(atorParaRemover));

        System.out.println("Ator " + atorParaRemover + " removido com sucesso!");
    }

    /**
     * Lista todos os atores cadastrados no sistema.
     */
    public static void listarAtores() {
        if (!listarNomesAtores().isEmpty()) {
            System.out.println(listarNomesAtores());
        }
    }


    /**
     * Fornece os dados de um ator específico.
     */
    public static void fichaTecnicaAtor() {
        ArrayList<ModelAtor> listaDeAtores = Catalogo.getCatalogoAtores();
        ModelAtor dadosAtor = null;
        System.out.println(listarNomesAtores());
        if (!listaDeAtores.isEmpty()) {
            System.out.print("Qual ator deseja pesquisar?");
            String nomeDoAtor = Menu.sc.nextLine();

            for (ModelAtor ator : listaDeAtores) {
                if (ator.getNome().equalsIgnoreCase(nomeDoAtor)) {
                    dadosAtor = ator;
                    break;
                }
            }
            if (dadosAtor != null) {
                System.out.print(getAtorByName(nomeDoAtor));
            } else {
                System.out.println("Ator não encontrado.");
            }
        }
    }


    public static String listarNomesAtores() {
        StringBuilder nomesFormatados = new StringBuilder("Atores Cadastrados:\n");

        ArrayList<ModelAtor> listaDeAtores = Catalogo.getCatalogoAtores();
        listaDeAtores.sort(Comparator.comparing(ModelAtor::getNome));

        for (int i = 0; i < listaDeAtores.size(); i++) {
            nomesFormatados.append(" - ").append(listaDeAtores.get(i).getNome());
            if (i < listaDeAtores.size() - 1) {
                nomesFormatados.append("\n");
            }
        }
        if (listaDeAtores.isEmpty()) {
            nomesFormatados.append("A lista de atores está vazia");
        }
        return nomesFormatados.toString();
    }

    public static ModelAtor getAtorByName(String nome) {
        for (ModelAtor ator : Catalogo.getCatalogoAtores()) {
            if (ator.getNome().equalsIgnoreCase(nome)) {
                return ator;
            }
        }
        return null;
    }

    public static Util.PapelAtor escolherPapelAtor() {
        Util.PapelAtor papelEscolhido;
        do {
            listarPapeis();
            System.out.println("Escolha o Papel do Ator");
            try {
                String papelInput = Menu.sc.nextLine();
                papelEscolhido = Util.PapelAtor.valueOf(papelInput.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Papel inválido! Tente novamente.");
            }
        } while (true);
        return papelEscolhido;
    }

    public static void listarPapeis() {
        System.out.println("\nPapeis disponíveis:");
        Util.PapelAtor[] papeis = Util.PapelAtor.values();
        for (int i = 0; i < papeis.length; i++) {
            if (papeis[i] != Util.PapelAtor.INDEFINIDO) {
                String nome = papeis[i].name().toLowerCase();
                nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
                System.out.print(nome);
                if (i < papeis.length - 2) {
                    System.out.print(" - ");
                }
            }
        }
        System.out.println();
    }
}