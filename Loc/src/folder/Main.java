package folder;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Veiculo> veiculos = new ArrayList<>();
    private static ArrayList<Locacao> locacoes = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Locadora de Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuItemCadastrarCliente = new JMenuItem("Cadastrar Cliente");
        JMenuItem menuItemCadastrarVeiculo = new JMenuItem("Cadastrar Veículo");
        menuCadastro.add(menuItemCadastrarCliente);
        menuCadastro.add(menuItemCadastrarVeiculo);

        JMenu menuLocacao = new JMenu("Locação");
        JMenuItem menuItemRealizarLocacao = new JMenuItem("Realizar Locação");
        JMenuItem menuItemVeiculosLocados = new JMenuItem("Veículos Locados");
        menuLocacao.add(menuItemRealizarLocacao);
        menuLocacao.add(menuItemVeiculosLocados);

        JMenu menuRelatorio = new JMenu("Relatório");
        JMenuItem menuItemRelatorioClientes = new JMenuItem("Gerar Relatório Clientes");
        JMenuItem menuItemRelatorioVeiculos = new JMenuItem("Gerar Relatório Veículos");
        JMenuItem menuItemRelatorioCompleto = new JMenuItem("Gerar Relatório Completo");
        menuRelatorio.add(menuItemRelatorioClientes);
        menuRelatorio.add(menuItemRelatorioVeiculos);
        menuRelatorio.add(menuItemVeiculosLocados);  
        menuRelatorio.add(menuItemRelatorioCompleto);

        menuBar.add(menuCadastro);
        menuBar.add(menuLocacao);
        menuBar.add(menuRelatorio);

        frame.setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new CardLayout());

        // Painel de cadastro de clientes
        JPanel panelCliente = new JPanel();
        panelCliente.setLayout(new GridLayout(6, 2));

        panelCliente.add(new JLabel("ID:"));
        JTextField textFieldClienteId = new JTextField();
        panelCliente.add(textFieldClienteId);

        panelCliente.add(new JLabel("Nome:"));
        JTextField textFieldClienteNome = new JTextField();
        panelCliente.add(textFieldClienteNome);

        panelCliente.add(new JLabel("CPF:"));
        JTextField textFieldClienteCpf = new JTextField();
        panelCliente.add(textFieldClienteCpf);

        panelCliente.add(new JLabel("Telefone:"));
        JTextField textFieldClienteTelefone = new JTextField();
        panelCliente.add(textFieldClienteTelefone);

        panelCliente.add(new JLabel("Endereço:"));
        JTextField textFieldClienteEndereco = new JTextField();
        panelCliente.add(textFieldClienteEndereco);

        JButton buttonClienteCadastrar = new JButton("Cadastrar Cliente");
        panelCliente.add(buttonClienteCadastrar);

        // Painel de cadastro de veículos
        JPanel panelVeiculo = new JPanel();
        panelVeiculo.setLayout(new GridLayout(7, 2));

        panelVeiculo.add(new JLabel("ID:"));
        JTextField textFieldVeiculoId = new JTextField();
        panelVeiculo.add(textFieldVeiculoId);

        panelVeiculo.add(new JLabel("Marca:"));
        JTextField textFieldVeiculoMarca = new JTextField();
        panelVeiculo.add(textFieldVeiculoMarca);

        panelVeiculo.add(new JLabel("Modelo:"));
        JTextField textFieldVeiculoModelo = new JTextField();
        panelVeiculo.add(textFieldVeiculoModelo);

        panelVeiculo.add(new JLabel("Ano:"));
        JTextField textFieldVeiculoAno = new JTextField();
        panelVeiculo.add(textFieldVeiculoAno);

        panelVeiculo.add(new JLabel("Placa:"));
        JTextField textFieldVeiculoPlaca = new JTextField();
        panelVeiculo.add(textFieldVeiculoPlaca);

        panelVeiculo.add(new JLabel("Disponível:"));
        JCheckBox checkBoxVeiculoDisponivel = new JCheckBox();
        panelVeiculo.add(checkBoxVeiculoDisponivel);

        JButton buttonVeiculoCadastrar = new JButton("Cadastrar Veículo");
        panelVeiculo.add(buttonVeiculoCadastrar);

        // Painel de locações
        JPanel panelLocacao = new JPanel();
        panelLocacao.setLayout(new GridLayout(7, 2));

        panelLocacao.add(new JLabel("ID:"));
        JTextField textFieldLocacaoId = new JTextField();
        panelLocacao.add(textFieldLocacaoId);

        panelLocacao.add(new JLabel("ID Cliente:"));
        JTextField textFieldLocacaoClienteId = new JTextField();
        panelLocacao.add(textFieldLocacaoClienteId);

        panelLocacao.add(new JLabel("ID Veículo:"));
        JTextField textFieldLocacaoVeiculoId = new JTextField();
        panelLocacao.add(textFieldLocacaoVeiculoId);

        panelLocacao.add(new JLabel("Data Início (yyyy-MM-dd):"));
        JTextField textFieldLocacaoDataInicio = new JTextField();
        panelLocacao.add(textFieldLocacaoDataInicio);

        panelLocacao.add(new JLabel("Data Fim (yyyy-MM-dd):"));
        JTextField textFieldLocacaoDataFim = new JTextField();
        panelLocacao.add(textFieldLocacaoDataFim);

        panelLocacao.add(new JLabel("Valor Total:"));
        JTextField textFieldLocacaoValorTotal = new JTextField();
        panelLocacao.add(textFieldLocacaoValorTotal);

        JButton buttonLocacaoCadastrar = new JButton("Realizar Locação");
        panelLocacao.add(buttonLocacaoCadastrar);

        // Painel de relatório
        JPanel panelRelatorio = new JPanel();
        panelRelatorio.setLayout(new BorderLayout());
        JTextArea textAreaRelatorio = new JTextArea();
        textAreaRelatorio.setEditable(false);
        JScrollPane scrollPaneRelatorio = new JScrollPane(textAreaRelatorio);
        panelRelatorio.add(scrollPaneRelatorio, BorderLayout.CENTER);

        panel.add(panelCliente, "Cliente");
        panel.add(panelVeiculo, "Veículo");
        panel.add(panelLocacao, "Locação");
        panel.add(panelRelatorio, "Relatório");

        menuItemCadastrarCliente.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Cliente");
        });

        menuItemCadastrarVeiculo.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Veículo");
        });

        menuItemRealizarLocacao.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Locação");
        });

        menuItemVeiculosLocados.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Relatório");
            Relatorio.gerarRelatorioVeiculosLocados(textAreaRelatorio, locacoes);
        });

        menuItemRelatorioClientes.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Relatório");
            Relatorio.gerarRelatorioClientes(textAreaRelatorio, clientes);
        });

        menuItemRelatorioVeiculos.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Relatório");
            Relatorio.gerarRelatorioVeiculos(textAreaRelatorio, veiculos);
        });

        menuItemRelatorioCompleto.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Relatório");
            Relatorio.gerarRelatorioCompleto(textAreaRelatorio, clientes, veiculos, locacoes);
        });

        buttonClienteCadastrar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(textFieldClienteId.getText());
                String nome = textFieldClienteNome.getText();
                String cpf = textFieldClienteCpf.getText();
                String telefone = textFieldClienteTelefone.getText();
                String endereco = textFieldClienteEndereco.getText();

                Cliente cliente = new Cliente(id, nome, cpf, telefone, endereco);
                clientes.add(cliente);
                JOptionPane.showMessageDialog(frame, "Cliente cadastrado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao cadastrar cliente: ID deve ser um número inteiro.");
            }
        });

        buttonVeiculoCadastrar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(textFieldVeiculoId.getText());
                String marca = textFieldVeiculoMarca.getText();
                String modelo = textFieldVeiculoModelo.getText();
                int ano = Integer.parseInt(textFieldVeiculoAno.getText());
                String placa = textFieldVeiculoPlaca.getText();
                boolean disponivel = checkBoxVeiculoDisponivel.isSelected();

                Veiculo veiculo = new Veiculo(id, marca, modelo, ano, placa, disponivel);
                veiculos.add(veiculo);
                JOptionPane.showMessageDialog(frame, "Veículo cadastrado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao cadastrar veículo: ID e Ano devem ser números inteiros.");
            }
        });

        buttonLocacaoCadastrar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(textFieldLocacaoId.getText());
                int clienteId = Integer.parseInt(textFieldLocacaoClienteId.getText());
                int veiculoId = Integer.parseInt(textFieldLocacaoVeiculoId.getText());
                String dataInicioStr = textFieldLocacaoDataInicio.getText();
                String dataFimStr = textFieldLocacaoDataFim.getText();
                double valorTotal = Double.parseDouble(textFieldLocacaoValorTotal.getText());

                Cliente cliente = buscarClientePorId(clienteId);
                if (cliente == null) {
                    JOptionPane.showMessageDialog(frame, "Erro ao realizar locação: Cliente não encontrado.");
                    return;
                }

                Veiculo veiculo = buscarVeiculoPorId(veiculoId);
                if (veiculo == null) {
                    JOptionPane.showMessageDialog(frame, "Erro ao realizar locação: Veículo não encontrado.");
                    return;
                }

                if (!veiculo.isDisponivel()) {
                    JOptionPane.showMessageDialog(frame, "Erro ao realizar locação: Veículo não está disponível.");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dataInicio = sdf.parse(dataInicioStr);
                Date dataFim = sdf.parse(dataFimStr);
                Locacao locacao = new Locacao(id, cliente, veiculo, dataInicio, dataFim, valorTotal);
                locacoes.add(locacao);
                veiculo.setDisponivel(false);
                JOptionPane.showMessageDialog(frame, "Locação realizada com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao realizar locação: IDs devem ser números inteiros e Valor Total deve ser um número.");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao realizar locação: Datas devem estar no formato yyyy-MM-dd.");
            }
        });

        frame.setVisible(true);
    }

    private static Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    private static Veiculo buscarVeiculoPorId(int id) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId() == id) {
                return veiculo;
            }
        }
        return null;
    }
}