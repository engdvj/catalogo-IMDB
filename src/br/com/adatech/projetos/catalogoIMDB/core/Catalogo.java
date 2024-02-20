package br.com.adatech.projetos.catalogoIMDB.core;

import br.com.adatech.projetos.catalogoIMDB.model.*;
import br.com.adatech.projetos.catalogoIMDB.service.*;
import br.com.adatech.projetos.catalogoIMDB.util.Util.*;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;

import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo {

    /**
     * Lista que armazena os filmes cadastrados no sistema.
     */

    private static ArrayList<ModelFilme> catalogo = new ArrayList<>();

    /**
     * Hashmap que armazena os roteristas e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do roteirista.
     */
    private static HashMap<ModelRoterista, ArrayList<ModelFilme>> mapRoteristasFilmes = new HashMap<>();

    public static HashMap<ModelRoterista, ArrayList<ModelFilme>> getRoteristas() {
        return mapRoteristasFilmes;
    }
    public static ArrayList<ModelFilme> getCatalogo() {
        return catalogo;
    }

    /**
     * Hashmap que armazena os diretores e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do diretor.
     */
    private static HashMap<ModelDiretor, ArrayList<ModelFilme>> mapDiretores = new HashMap<>();
    public static HashMap<ModelDiretor, ArrayList<ModelFilme>> getDiretores() {
        return mapDiretores;
    }
    /**
     * Hashmap que armazena os atores e seus respectivos filmes.
     * A chave do mapa é uma String representando o nome do ator.
     */
    private static HashMap<ModelAtor, ArrayList<ModelFilme>> mapAtores = new HashMap<>();

    public static HashMap<ModelAtor, ArrayList<ModelFilme>> getAtores() {
        return mapAtores;
    }

    /**
     * Associa uma pessoa a um filme.
     */
    public static void associarFilme() {
        ServiceFilme.listarFilmes();
        System.out.println("Escolha o filme que gostaria de associar:");
        String informacao = Menu.sc.nextLine();
        ModelFilme filme = ServiceFilme.getFilmeByTitulo(informacao);
        int escolha;
        do {
            System.out.println("Qual entidade gostaria de vincular ao filme?");
            System.out.println("""
                    (1) - Ator
                    (2) - Diretor
                    (3) - Roterista
                    (4) - Voltar ao menu anterior""");
            escolha = Menu.sc.nextInt();
            Menu.sc.nextLine();

            switch (escolha) {

                case 1:
                    ServiceAtor.listarAtores();
                    System.out.println("Escolha o Ator que gostaria de associar:");
                    informacao = Menu.sc.nextLine();
                    ModelAtor ator = ServiceAtor.getAtorByName(informacao);
                    PapelAtor papelAtor = ServiceAtor.escolherPapelAtor();
                    filme.addPessoa(ator, papelAtor);
                    break;
                case 2:
                    ServiceDiretor.listarDiretores();
                    System.out.println("Escolha o Diretor que gostaria de associar:");
                    informacao = Menu.sc.nextLine();
                    ModelDiretor diretor = ServiceDiretor.getDiretorByName(informacao);
                    filme.addPessoa(diretor);
                    break;
                case 3:
                    ServiceRoterista.listarRoteristas();
                    System.out.println("Escolha o Roterista que gostaria de associar:");
                    informacao = Menu.sc.nextLine();
                    ModelRoterista roterista = ServiceRoterista.getRoteristaByName(informacao);
                    AreaRoteirista area = ServiceRoterista.escolherAreaRoterista();
                    filme.addPessoa(roterista, area);
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        } while (escolha != 4);
    }

    /**
     * Desassocia uma pessoa de um filme.
     */
    public static void desassociarFilme() {
        System.out.println("Em aguardo...");
    }
}

