package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;
import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;
import br.com.adatech.projetos.catalogoIMDB.model.ModelRoterista;
import br.com.adatech.projetos.catalogoIMDB.util.Util;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;

import java.util.*;


/**
 * Classe que gerencia as operações relacionadas a roteristas no sistema de catálogo de filmes.
 * Esta classe oferece funcionalidades para adicionar, editar, remover e listar roteristas,
 */
public class ServiceRoterista {

    /**
     * Adiciona um roterista ao sistema.
     */
    public static void adicionarRoterista() {

        String[] dados = new String[3];
        System.out.print("Informe o nome completo: ");
        dados[0] = Menu.sc.nextLine();
        System.out.print("Informe o CPF: ");
        dados[1] = Util.validarCPF();
        System.out.println("Digite a data de nascimento (formato DD/MM/YYYY):");
        dados[2] = Util.validarDataNascimento();
        ModelRoterista roterista = new ModelRoterista(dados);

        Catalogo.getRoteristas().put(roterista, Catalogo.getCatalogo());
        System.out.println("Roterista " + roterista.getNome() + " Cadastrado");
    }

    /**
     * Edita os detalhes de um roterista existente no sistema.
     */
    public static void editarRoterista() {
        listarRoteristas();
        System.out.print("Digite o nome do roterista que gostaria de alterar: ");
        String informacao = Menu.sc.nextLine();
        ModelRoterista roterista = getRoteristaByName(informacao);
        if (roterista != null) {
            System.out.println("Qual informação gostaria de editar?");
            System.out.println("""
                (1) - Nome
                (2) - CPF
                (3) - Data de Nascimento""");
            int escolha = Menu.sc.nextInt();
            Menu.sc.nextLine();
            switch (escolha) {
                case 1:
                    System.out.println("Digite o novo nome:");
                    informacao = Menu.sc.nextLine();
                    roterista.setNome(informacao);
                    System.out.println("Nome alterado!");
                    break;
                case 2:
                    System.out.println("Digite o novo CPF:");
                    informacao = Util.validarCPF();
                    roterista.setCpf(informacao);
                    System.out.println("CPF alterado!");
                    break;
                case 3:
                    System.out.println("Digite a nova data de nascimento:");
                    informacao = Util.validarDataNascimento();
                    roterista.setDataDeNascimento(informacao);
                    System.out.println("Data de nascimento alterada!");
                    break;
                default:
                    System.out.println("Escolha uma opção valida!!\n");
                    break;
            }
        }
    }

    /**
     * Remove um roterista do sistema.
     */
    public static void removerRoterista() {
        listarRoteristas();
        System.out.println("Digite o nome do roterista que gostaria de remover:");
        String nome = Menu.sc.nextLine();
        if (Catalogo.getRoteristas().remove(getRoteristaByName(nome)) != null) {
            System.out.println("Roteirista " + nome + " Removido!");
        }
    }

    /**
     * Lista todos os roteristas cadastrados no sistema.
     */
    public static void listarRoteristas() {
        System.out.println("Roteiristas Cadastrados:");
        for (HashMap.Entry<ModelRoterista, ArrayList<ModelFilme>> roterista : Catalogo.getRoteristas().entrySet()) {
            System.out.println(" - " + roterista.getKey().getNome());
        }
    }

    /**
     * Fornece os dados de um roterista específico.
     */
    public static void fichaTecnicaRoterista() {
        listarRoteristas();
        System.out.println("Digite o nome do roterista:");
        String nome = Menu.sc.nextLine();
        System.out.println(getRoteristaByName(nome));
    }

    public static ModelRoterista getRoteristaByName(String nome) {
        try {
            for (Map.Entry<ModelRoterista, ArrayList<ModelFilme>> roterista : Catalogo.getRoteristas().entrySet()) {
                if (roterista.getKey().getNome().equalsIgnoreCase(nome)) {
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