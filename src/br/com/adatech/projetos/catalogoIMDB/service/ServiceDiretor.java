package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;
import br.com.adatech.projetos.catalogoIMDB.model.*;
import br.com.adatech.projetos.catalogoIMDB.util.*;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Classe que gerencia as operações relacionadas a diretores no sistema de catálogo de filmes.
 * Esta classe oferece funcionalidades para adicionar, editar, remover e listar diretores,
 * além de associar e desassociar filmes cadastrados.
 */
public class ServiceDiretor {

    /**
     * Adiciona um diretor ao sistema.
     */
    public static void adicionarDiretor() {

        String[] dados = new String[3];

        System.out.print("Digite o nome completo:");
        dados[0] = Menu.sc.nextLine();
        System.out.print("Digite o CPF:");
        dados[1] = Util.validarCPF();
        System.out.println("Digite a data de nascimento (formato DD/MM/YYYY):");
        dados[2] = Util.validarDataNascimento();
        ModelDiretor diretor = new ModelDiretor(dados);

        Catalogo.getCatalogoDiretores().add(diretor);
        System.out.println("O diretor " + diretor.getNome() + " foi adicionado com sucesso!!\n");}
    /**
     * Edita os detalhes de um diretor existente no sistema.
     */
    public static void editarDiretor() {
        ArrayList<ModelDiretor> listaDeDiretores = Catalogo.getCatalogoDiretores();
        System.out.println(listarNomesDiretores());
        System.out.print("Digite o nome do Diretor que deseja editar: ");
        String nomeDiretorEditar = Menu.sc.nextLine();

        ModelDiretor diretorParaEditar = null;
        for (ModelDiretor diretor : listaDeDiretores) {
            if (diretor.getNome().equalsIgnoreCase(nomeDiretorEditar)) {
                diretorParaEditar = diretor;
                break;
            }
        }

        if (diretorParaEditar != null) {
            System.out.println("O que deseja editar?");
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
                    diretorParaEditar.setNome(novoNome);
                    System.out.println("Nome alterado!");
                    break;
                case 2:
                    System.out.print("Digite o novo CPF: ");
                    String novoCPF = Util.validarCPF();
                    diretorParaEditar.setCpf(novoCPF);
                    System.out.println("CPF alterado!");
                    break;
                case 3:
                    System.out.print("Digite a nova data de nascimento (no formato YYYY-MM-DD): ");
                    String novaDataNascimento = Util.validarDataNascimento();
                    diretorParaEditar.setDataDeNascimento(novaDataNascimento);
                    System.out.println("Data de nascimento alterada!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Diretor não encontrado.");
        }
    }
    /**
     * Remove um diretor do sistema.
     */
    public static void removerDiretor() {
        ArrayList<ModelDiretor> listaDeDiretores = Catalogo.getCatalogoDiretores();
        System.out.println(listarNomesDiretores());
        System.out.print("Qual Diretor deseja remover? ");
        String diretorParaRemover = Menu.sc.nextLine();

        listaDeDiretores.removeIf(diretor -> diretor.getNome().equalsIgnoreCase(diretorParaRemover));

        System.out.println("O diretor " +diretorParaRemover+ " removido com sucesso!");
    }

    /**
     * Lista todos os diretores cadastrados no sistema.
     */
    public static void listarDiretores() {
        if(!listarNomesDiretores().isEmpty()){
            System.out.println(listarNomesDiretores());
        }
    }

    /**
     * Fornece os dados de um diretor específico.
     */
    public static void fichaTecnicaDiretor() {

        ArrayList<ModelDiretor> listaDeDiretores = Catalogo.getCatalogoDiretores();
        ModelDiretor dadosDiretor = null;
        System.out.println(listarNomesDiretores());
        if (!listaDeDiretores.isEmpty()) {
            System.out.print("Qual diretor deseja pesquisar?");
            String nomeDoDiretor = Menu.sc.nextLine();

            for (ModelDiretor diretor : listaDeDiretores) {
                if (diretor.getNome().equalsIgnoreCase(nomeDoDiretor)) {
                    dadosDiretor = diretor;
                    break;
                }
            }

            if (dadosDiretor != null) {
                System.out.print("Detalhes do diretor\n" +
                        "Nome: " + dadosDiretor.getNome() +
                        "\nCPF: " + dadosDiretor.getCpf() +
                        "\nData de nascimento: " + dadosDiretor.getDataDeNascimento() +
                        "\nQuantidade de papeis: " + dadosDiretor.getQuantidadeDeFilmesDirigidos() +
                        "\n"
                );
            } else {
                System.out.println("Diretor não encontrado.");
            }
        }}

    public static String listarNomesDiretores() {
        ArrayList<ModelDiretor> listaDeDiretores = Catalogo.getCatalogoDiretores();
        StringBuilder nomesFormatados = new StringBuilder();
        int i = 0;

        if (!listaDeDiretores.isEmpty()) {
            for (ModelDiretor diretor : listaDeDiretores) {
                nomesFormatados.append(" - ").append(diretor.getNome());
                if ( i < listaDeDiretores.size() -1){
                    nomesFormatados.append("\n");
                }
                i++;
            }
        } else {
            nomesFormatados.append("A lista de diretores está vazia");
        }
        return nomesFormatados.toString();
    }
    public static ModelDiretor getDiretorByName(String nome) {
        try {
            for (ModelDiretor diretor : Catalogo.getCatalogoDiretores()) {
                if (diretor.getNome().equalsIgnoreCase(nome)) {
                    return diretor;
                }
            }
            throw new NoSuchElementException("Ator com o nome '" + nome + "' não encontrado.");
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}