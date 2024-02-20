package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;
import br.com.adatech.projetos.catalogoIMDB.model.ModelDiretor;
import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;

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

        System.out.print("Digite o nome do diretor:");
        dados[0] = Menu.sc.nextLine();
        System.out.print("Digite o CPF do diretor:");
        dados[1] = Menu.sc.nextLine();
        System.out.print("Digite a data de nascimento do diretor (no formato YYYY-MM-DD):");
        dados[2] = Menu.sc.nextLine();
        ModelDiretor diretor = new ModelDiretor(dados);

        Catalogo.getDiretores().put(diretor, Catalogo.getCatalogo());
        System.out.println("O diretor " + diretor.getNome() + " foi adicionado com sucesso!!\n");}
    /**
     * Edita os detalhes de um diretor existente no sistema.
     */
    public static void editarDiretor() {
        HashMap<ModelDiretor, ArrayList<ModelFilme>> listaDeDiretores = Catalogo.getDiretores();
        System.out.println(listarNomesDiretores());
        System.out.print("Digite o nome do Diretor que deseja editar: ");
        String nomeDiretorEditar = Menu.sc.nextLine();

        ModelDiretor diretorParaEditar = null;
        for (ModelDiretor diretor : listaDeDiretores.keySet()) {
            if (diretor.getNome().equalsIgnoreCase(nomeDiretorEditar)) {
                diretorParaEditar = diretor;
                break;
            }
        }

        if (diretorParaEditar != null) {
            System.out.println("O que deseja editar?");
            System.out.println("1- Nome");
            System.out.println("2- CPF");
            System.out.println("3- Data de Nascimento");

            System.out.print("->");
            Menu.sc.nextLine();
            int opcao = Menu.sc.nextInt();
            Menu.sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = Menu.sc.nextLine();
                    diretorParaEditar.setNome(novoNome);
                    break;
                case 2:
                    System.out.print("Digite o novo CPF: ");
                    String novoCPF = Menu.sc.nextLine();
                    diretorParaEditar.setCpf(novoCPF);
                    break;
                case 3:
                    System.out.print("Digite a nova data de nascimento (no formato YYYY-MM-DD): ");
                    String novaDataNascimento = Menu.sc.nextLine();
                    diretorParaEditar.setDataDeNascimento(novaDataNascimento);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("As informações do diretor foram atualizadas com sucesso!");
        } else {
            System.out.println("diretor não encontrado.");
        }
    }
    /**
     * Remove um diretor do sistema.
     */
    public static void removerDiretor() {
        HashMap<ModelDiretor, ArrayList<ModelFilme>> listaDeDiretores = Catalogo.getDiretores();
        System.out.println(listarNomesDiretores());
        System.out.print("Qual Diretor deseja remover? ");
        String diretorParaRemover = Menu.sc.nextLine();

        listaDeDiretores.keySet().removeIf(diretor -> diretor.getNome().equalsIgnoreCase(diretorParaRemover));

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
    public static void dadosDiretor() {

        HashMap<ModelDiretor, ArrayList<ModelFilme>> listaDeDiretores = Catalogo.getDiretores();
        ModelDiretor dadosDiretor = null;
        System.out.println(listarNomesDiretores());
        if (!listaDeDiretores.isEmpty()) {
            System.out.print("Qual diretor deseja pesquisar?");
            String nomeDoDiretor = Menu.sc.nextLine();

            for (ModelDiretor diretor : listaDeDiretores.keySet()) {
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
        HashMap<ModelDiretor, ArrayList<ModelFilme>> listaDeDiretores = Catalogo.getDiretores();
        StringBuilder nomesFormatados = new StringBuilder();

        if (!listaDeDiretores.isEmpty()) {
            for (ModelDiretor diretor : listaDeDiretores.keySet()) {
                nomesFormatados.append("-").append(diretor.getNome()).append("\n");
            }
        } else {
            nomesFormatados.append("A lista de diretor está vazia");
        }
        return nomesFormatados.toString();
    }

}