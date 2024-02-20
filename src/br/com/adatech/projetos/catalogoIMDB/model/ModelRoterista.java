package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.*;

import java.util.ArrayList;

/**
 * Classe que representa um Roteirista de filme
 * Contém construtores, parâmetros, além de getters e setters
 * @ModelPessoa - Classe abstrata mãe que possui atributos e métodos próprios
 */
public class ModelRoterista extends ModelPessoa {

    private int quantidadeDeRoteirosEscritos;
    private ArrayList<AreaRoteirista> area = new ArrayList<>();

    public ModelRoterista(String [] dados) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
        area.add(AreaRoteirista.INDEFINIDO);
    }

    public int getQuantidadeDeRoteirosEscritos() {
        return quantidadeDeRoteirosEscritos;
    }

    public void novoRoteiro(AreaRoteirista area) {
        quantidadeDeRoteirosEscritos++;
        this.area.add(area);
    }

    @Override
    public String toString() {
        String topBottomBorder = "*".repeat(50);
        String middleBar = "-".repeat(50);
        String title = centerString("INFORMAÇÕES DO ROTERISTA", 50);

        return topBottomBorder + "\n" +
                title +
                topBottomBorder + "\n" +
                formatLine("DADOS PESSOAIS", "*") +
                middleBar + "\n" +
                formatLine("- Nome -", nome) +
                formatLine("- CPF -", cpf) +
                formatLine("- Data de Nascimento -", String.valueOf(dataDeNascimento)) +
                middleBar + "\n" +
                formatLine("PARTICIPAÇÕES", String.valueOf(quantidadeDeRoteirosEscritos)) +
                topBottomBorder + "\n";
    }

    private String centerString(String text, int width) {
        if (text == null || text.trim().isEmpty()) {
            text = "N/A";
        }
        else if(text == "*"){
            return "";
        }
        int paddingSize = (width - text.length()) / 2;
        String padding = " ".repeat(Math.max(0, paddingSize));
        return padding + text + padding + (text.length() % 2 == 1 ? " " : "") + "\n";
    }

    private String formatLine(String label, String content) {
        String centeredLabel = centerString(label, 50);
        String centeredContent = centerString(content != null ? content : "N/A", 50);
        return centeredLabel + centeredContent;
    }
}
