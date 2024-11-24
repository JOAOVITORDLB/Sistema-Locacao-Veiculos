
package folder;

import java.util.ArrayList;
import javax.swing.JTextArea;

class Relatorio {
    public static void gerarRelatorioClientes(JTextArea textArea, ArrayList<Cliente> clientes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Clientes\n");
        for (Cliente cliente : clientes) {
            sb.append(cliente).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void gerarRelatorioVeiculos(JTextArea textArea, ArrayList<Veiculo> veiculos) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Veículos\n");
        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void gerarRelatorioVeiculosLocados(JTextArea textArea, ArrayList<Locacao> locacoes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Veículos Locados\n");
        for (Locacao locacao : locacoes) {
            sb.append(locacao).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void gerarRelatorioCompleto(JTextArea textArea, ArrayList<Cliente> clientes, ArrayList<Veiculo> veiculos, ArrayList<Locacao> locacoes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório Completo\n\n");

        sb.append("Clientes:\n");
        for (Cliente cliente : clientes) {
            sb.append(cliente).append("\n");
        }
        sb.append("\nVeículos:\n");
        for (Veiculo veiculo : veiculos) {
            sb.append(veiculo).append("\n");
        }
        sb.append("\nLocações:\n");
        for (Locacao locacao : locacoes) {
            sb.append(locacao).append("\n");
        }

        textArea.setText(sb.toString());
    }
}