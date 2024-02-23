package br.com.adatech.projetos.catalogoIMDB.core;

import br.com.adatech.projetos.catalogoIMDB.model.*;
import br.com.adatech.projetos.catalogoIMDB.service.*;
import br.com.adatech.projetos.catalogoIMDB.util.Util.*;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;

import java.util.ArrayList;

public class Catalogo {

    /**
     * Lista que armazena os atores cadastrados no sistema.
     */
    private final static ArrayList<ModelAtor> catalogoAtores = new ArrayList<>();

    /**
     * Lista que armazena os diretores cadastrados no sistema.
     */
    private final static ArrayList<ModelDiretor> catalogoDiretores = new ArrayList<>();

    /**
     * Lista que armazena os filmes cadastrados no sistema.
     */
    private final static ArrayList<ModelFilme> catalogoFilmes = new ArrayList<>();
    /**
     * Lista que armazena os roteiristas cadastrados no sistema.
     */
    private final static ArrayList<ModelRoteirista> catalogoRoteiristas = new ArrayList<>();


    public static ArrayList<ModelAtor> getCatalogoAtores() {
        return catalogoAtores;
    }

    public static ArrayList<ModelDiretor> getCatalogoDiretores() {
        return catalogoDiretores;
    }

    public static ArrayList<ModelFilme> getCatalogoFilmes() {
        return catalogoFilmes;
    }

    public static ArrayList<ModelRoteirista> getCatalogoRoteiristas() {
        return catalogoRoteiristas;
    }

    /**
     * Associa uma pessoa a um filme.
     */
    public static void associarFilme() {
        ServiceFilme.listarFilmes();
        System.out.println("Escolha o filme que gostaria de associar:");
        String informacao = Menu.sc.nextLine();
        ModelFilme filme = ServiceFilme.getFilmeByTitulo(informacao);
        if (filme == null) {
            return;
        }
        int escolha;
        do {
            System.out.println("Qual entidade gostaria de vincular ao filme?");
            System.out.println("""
                    (1) - Ator
                    (2) - Diretor
                    (3) - Roteirista
                    (4) - Voltar ao menu anterior""");

            while (!Menu.sc.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                Menu.sc.next(); // Limpa a entrada incorreta
            }
            escolha = Menu.sc.nextInt();
            Menu.sc.nextLine();
            switch (escolha) {

                case 1:
                    ServiceAtor.listarAtores();
                    System.out.println("Escolha o Ator que gostaria de associar:");
                    informacao = Menu.sc.nextLine();
                    ModelAtor ator = ServiceAtor.getAtorByName(informacao);
                    if (!filme.getArtistas().contains(ator)) {
                        PapelAtor papelAtor = ServiceAtor.escolherPapelAtor();
                        filme.addPessoa(ator, papelAtor, filme);
                    } else {
                        System.out.println("O Artista escolhido já está vinculado nesse filme!");
                    }
                    break;
                case 2:
                    if (filme.getDiretor() == null) {

                        ServiceDiretor.listarDiretores();
                        System.out.println("Escolha o Diretor que gostaria de associar:");
                        informacao = Menu.sc.nextLine();
                        ModelDiretor diretor = ServiceDiretor.getDiretorByName(informacao);
                        AreaDiretor papelDiretor = ServiceDiretor.escolherAreaDiretor();
                        filme.addPessoa(diretor, papelDiretor, filme);
                    } else {
                        System.out.println("Já existe um diretor associado a esse filme!");
                    }
                    break;
                case 3:
                    ServiceRoteirista.listarRoteiristas();
                    System.out.println("Escolha o Roteirista que gostaria de associar:");
                    informacao = Menu.sc.nextLine();
                    ModelRoteirista roteirista = ServiceRoteirista.getRoteiristaByName(informacao);
                    if (!filme.getRoteiristas().contains(roteirista)) {
                        AreaRoteirista area = ServiceRoteirista.escolherAreaRoteirista();
                        filme.addPessoa(roteirista, area, filme);
                    } else {
                        System.out.println("O Roteirista escolhido já está vinculado nesse filme!");
                    }
                    break;
                case 4:
                    System.out.println("Voltando ao menu anterior..");
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
        ServiceFilme.listarFilmes();
        System.out.println("Escolha o filme que gostaria de desaassociar:");
        String informacao = Menu.sc.nextLine();
        ModelFilme filme = ServiceFilme.getFilmeByTitulo(informacao);
        if (filme == null) {
            return;
        }
        int escolha;
        do {
            System.out.println("Qual entidade gostaria de desvincular do filme?");
            System.out.println("""
                    (1) - Ator
                    (2) - Diretor
                    (3) - Roteirista
                    (4) - Voltar ao menu anterior""");

            while (!Menu.sc.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                Menu.sc.next(); // Limpa a entrada incorreta
            }
            escolha = Menu.sc.nextInt();
            Menu.sc.nextLine();
            switch (escolha) {

                case 1:
                    ArrayList<? extends ModelPessoa> atores = filme.getArtistas();
                    if (!atores.isEmpty()) {
                        System.out.println(listarNomes(atores));
                        System.out.println("Escolha o Ator que gostaria de desassociar:");
                        informacao = Menu.sc.nextLine();
                        ModelAtor ator = ServiceAtor.getAtorByName(informacao);
                        if (filme.getArtistas().contains(ator)) {
                            PapelAtor papelAtor = ator.getPapelAtor(filme.getTitulo());
                            filme.removePessoa(ator, papelAtor, filme);
                            System.out.println("O Ator " + ator.getNome() + " foi desvinculado do filme!");

                        } else {
                            System.out.println("O Ator escolhido não está vinculado nesse filme!");
                        }
                    } else {
                        System.out.println("Não existe nenhum ator vinculado nesse filme!");
                    }

                    break;
                case 2:
                    ModelDiretor diretor = filme.getDiretor();
                    if (diretor != null) {
                        AreaDiretor area = diretor.getAreaDiretor(filme.getTitulo());
                        filme.removePessoa(diretor, area, filme);
                        System.out.println("O Diretor " + diretor.getNome() + " foi desvinculado do filme!");
                    } else {
                        System.out.println("Não existe nenhum diretor vinculado nesse filme!");
                    }
                    break;
                case 3:
                    ArrayList<? extends ModelPessoa> roteiristas = filme.getRoteiristas();
                    if (!roteiristas.isEmpty()) {
                        System.out.println(listarNomes(roteiristas));
                        System.out.println("Escolha o Roteirista que gostaria de desassociar:");
                        informacao = Menu.sc.nextLine();
                        ModelRoteirista roteirista = ServiceRoteirista.getRoteiristaByName(informacao);
                        if (filme.getRoteiristas().contains(roteirista)) {
                            AreaRoteirista areaRoteirista = roteirista.getAreaRoteirista(filme.getTitulo());
                            filme.removePessoa(roteirista, areaRoteirista, filme);
                            System.out.println("O Roteirista " + roteirista.getNome() + " foi desvinculado do filme!");

                        } else {
                            System.out.println("O Roteirista escolhido não está vinculado nesse filme!");
                        }
                    } else {
                        System.out.println("Não existe nenhum roteirista vinculado nesse filme!");
                    }
                    break;
                case 4:
                    System.out.println("Voltando ao menu anterior..");
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        } while (escolha != 4);
    }

    public static String listarNomes(ArrayList<? extends ModelPessoa> list) {
        StringBuilder nomesFormatados = new StringBuilder();
        int i = 0;

        if (!list.isEmpty()) {
            for (ModelPessoa pessoa : list) {
                nomesFormatados.append(" - ").append(pessoa.getNome());
                if (i < list.size() - 1) {
                    nomesFormatados.append("\n");
                }
                i++;
            }
        } else {
            nomesFormatados.append("A lista está vazia");
        }
        return nomesFormatados.toString();
    }
}


