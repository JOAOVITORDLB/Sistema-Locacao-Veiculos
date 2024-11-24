
package folder;

import java.text.SimpleDateFormat;
import java.util.Date;

class Locacao {
    private int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private Date dataInicio;
    private Date dataFim;
    private double valorTotal;

    public Locacao(int id, Cliente cliente, Veiculo veiculo, Date dataInicio, Date dataFim, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
    }

   @Override
public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return "ID: " + id + "\n" +
           "Cliente: " + cliente + "\n" +
           "Veículo: " + veiculo + "\n" +
           "Data Início: " + sdf.format(dataInicio) + "\n" +
           "Data Fim: " + sdf.format(dataFim) + "\n" +
           "Valor Total: " + valorTotal + "\n";
}
}