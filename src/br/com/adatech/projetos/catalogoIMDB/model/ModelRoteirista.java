package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util;
import br.com.adatech.projetos.catalogoIMDB.util.Util.*;

import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Classe que representa um Roteirista de filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelRoteirista extends ModelPessoa {

    private final HashMap<ModelFilme, Enum<?>> area = new HashMap<>();

    public ModelRoteirista(String [] dados) {
        super.nome = dados [0];
        super.cpf = dados[1];
        setDataDeNascimento(dados[2]);
    }

    public void novaParticipacao(Enum<?> area,ModelFilme filme) {
        super.participacoes.add(filme);
        this.area.put(filme,area);
    }
    public void removeParticipacao(Enum<?> areaRoteirista, ModelFilme filme) {
        super.participacoes.remove(filme);
        area.remove(filme,areaRoteirista);
    }

    public AreaRoteirista getAreaRoteirista(String tituloFilme) {
        for (HashMap.Entry<ModelFilme, Enum<?>> entrada : this.area.entrySet()) {
            if (entrada.getKey().getTitulo().equals(tituloFilme)) {
                return (AreaRoteirista) entrada.getValue();
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
            List<Map.Entry<ModelFilme, Enum<?>>> sortedEntries = Util.getSortedCopy(area.entrySet(),
                    Map.Entry.comparingByKey(Comparator.comparing(ModelFilme::getTitulo)));

            for (Map.Entry<ModelFilme, Enum<?>> entry : sortedEntries) {
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
                formatLine("- CPF -", formatoCPF()) +
                formatLine("- Data de Nascimento -", Util.dataFormatada(dataDeNascimento)) +
                middleBar + "\n" +
                formatLine("PARTICIPAÇÕES", "*") +
                middleBar + "\n" +
                filmesStr +
                topBottomBorder + "\n";
    }

    private String centerString(String text, int width) {
        if (text == null || text.trim().isEmpty()) {
            text = "N/A";
        }
        else if(text.equals("*")){
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
