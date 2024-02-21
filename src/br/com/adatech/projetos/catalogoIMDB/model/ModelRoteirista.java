package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.*;

import java.util.*;

/**
 * Classe que representa um Roteirista de filme
 * Contém construtores, parâmetros, além de getters e setters
 * @ModelPessoa - Classe abstrata mãe que possui atributos e métodos próprios
 */
public class ModelRoteirista extends ModelPessoa {

    private int quantidadeDeRoteirosEscritos;
    private HashMap<ModelFilme, AreaRoteirista> area = new HashMap<>();

    public ModelRoteirista(String [] dados) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
    }

    public int getQuantidadeDeRoteirosEscritos() {
        return quantidadeDeRoteirosEscritos;
    }

    public void novoRoteiro(AreaRoteirista area,ModelFilme filme) {
        quantidadeDeRoteirosEscritos++;
        super.participacoes.add(filme);
        this.area.put(filme,area);
    }

    public AreaRoteirista getAreaRoteirista(String tituloFilme) {
        for (HashMap.Entry<ModelFilme, AreaRoteirista> entrada : this.area.entrySet()) {
            if (entrada.getKey().getTitulo().equals(tituloFilme)) {
                return entrada.getValue();
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder filmesStr = new StringBuilder();

        if (super.participacoes.isEmpty()) {
            filmesStr.append(centerString("N/A", 50));
        } else {
            // Ordenando a lista de filmes baseada no título
            List<Map.Entry<ModelFilme, AreaRoteirista>> sortedEntries = new ArrayList<>(area.entrySet());
            sortedEntries.sort(Map.Entry.comparingByKey(Comparator.comparing(ModelFilme::getTitulo)));

            for (Map.Entry<ModelFilme, AreaRoteirista> entry : sortedEntries) {
                String line = "Filme: " + entry.getKey().getTitulo() + " / Papel: " + entry.getValue();
                filmesStr.append(centerString(line, 50));
            }
        }

        // Construindo o restante da string
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
                formatLine("PARTICIPAÇÕES", "*") +
                middleBar + "\n" +
                filmesStr.toString() +
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
