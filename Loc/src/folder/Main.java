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
        JMenuItem menuItemCadastrarVeiculo = new JMenuItem("Cadastrar Ve�culo");
        menuCadastro.add(menuItemCadastrarCliente);
        menuCadastro.add(menuItemCadastrarVeiculo);

        JMenu menuLocacao = new JMenu("Loca��o");
        JMenuItem menuItemRealizarLocacao = new JMenuItem("Realizar Loca��o");
        JMenuItem menuItemVeiculosLocados = new JMenuItem("Ve�culos Locados");
        menuLocacao.add(menuItemRealizarLocacao);
        menuLocacao.add(menuItemVeiculosLocados);

        JMenu menuRelatorio = new JMenu("Relat�rio");
        JMenuItem menuItemRelatorioClientes = new JMenuItem("Gerar Relat�rio Clientes");
        JMenuItem menuItemRelatorioVeiculos = new JMenuItem("Gerar Relat�rio Ve�culos");
        JMenuItem menuItemRelatorioCompleto = new JMenuItem("Gerar Relat�rio Completo");
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

        panelCliente.add(new JLabel("Endere�o:"));
        JTextField textFieldClienteEndereco = new JTextField();
        panelCliente.add(textFieldClienteEndereco);

        JButton buttonClienteCadastrar = new JButton("Cadastrar Cliente");
        panelCliente.add(buttonClienteCadastrar);

        // Painel de cadastro de ve�culos
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

        panelVeiculo.add(new JLabel("Dispon�vel:"));
        JCheckBox checkBoxVeiculoDisponivel = new JCheckBox();
        panelVeiculo.add(checkBoxVeiculoDisponivel);

        JButton buttonVeiculoCadastrar = new JButton("Cadastrar Ve�culo");
        panelVeiculo.add(buttonVeiculoCadastrar);

        // Painel de loca��es
        JPanel panelLocacao = new JPanel();
        panelLocacao.setLayout(new GridLayout(7, 2));

        panelLocacao.add(new JLabel("ID:"));
        JTextField textFieldLocacaoId = new JTextField();
        panelLocacao.add(textFieldLocacaoId);

        panelLocacao.add(new JLabel("ID Cliente:"));
        JTextField textFieldLocacaoClienteId = new JTextField();
        panelLocacao.add(textFieldLocacaoClienteId);

        panelLocacao.add(new JLabel("ID Ve�culo:"));
        JTextField textFieldLocacaoVeiculoId = new JTextField();
        panelLocacao.add(textFieldLocacaoVeiculoId);

        panelLocacao.add(new JLabel("Data In�cio (yyyy-MM-dd):"));
        JTextField textFieldLocacaoDataInicio = new JTextField();
        panelLocacao.add(textFieldLocacaoDataInicio);

        panelLocacao.add(new JLabel("Data Fim (yyyy-MM-dd):"));
        JTextField textFieldLocacaoDataFim = new JTextField();
        panelLocacao.add(textFieldLocacaoDataFim);

        panelLocacao.add(new JLabel("Valor Total:"));
        JTextField textFieldLocacaoValorTotal = new JTextField();
        panelLocacao.add(textFieldLocacaoValorTotal);

        JButton buttonLocacaoCadastrar = new JButton("Realizar Loca��o");
        panelLocacao.add(buttonLocacaoCadastrar);

        // Painel de relat�rio
        JPanel panelRelatorio = new JPanel();
        panelRelatorio.setLayout(new BorderLayout());
        JTextArea textAreaRelatorio = new JTextArea();
        textAreaRelatorio.setEditable(false);
        JScrollPane scrollPaneRelatorio = new JScrollPane(textAreaRelatorio);
        panelRelatorio.add(scrollPaneRelatorio, BorderLayout.CENTER);

        panel.add(panelCliente, "Cliente");
        panel.add(panelVeiculo, "Ve�culo");
        panel.add(panelLocacao, "Loca��o");
        panel.add(panelRelatorio, "Relat�rio");

        menuItemCadastrarCliente.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Cliente");
        });

        menuItemCadastrarVeiculo.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Ve�culo");
        });

        menuItemRealizarLocacao.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Loca��o");
        });

        menuItemVeiculosLocados.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Relat�rio");
            Relatorio.gerarRelatorioVeiculosLocados(textAreaRelatorio, locacoes);
        });

        menuItemRelatorioClientes.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Relat�rio");
            Relatorio.gerarRelatorioClientes(textAreaRelatorio, clientes);
        });

        menuItemRelatorioVeiculos.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Relat�rio");
            Relatorio.gerarRelatorioVeiculos(textAreaRelatorio, veiculos);
        });

        menuItemRelatorioCompleto.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, "Relat�rio");
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
                JOptionPane.showMessageDialog(frame, "Erro ao cadastrar cliente: ID deve ser um n�mero inteiro.");
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
                JOptionPane.showMessageDialog(frame, "Ve�culo cadastrado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao cadastrar ve�culo: ID e Ano devem ser n�meros inteiros.");
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
                    JOptionPane.showMessageDialog(frame, "Erro ao realizar loca��o: Cliente n�o encontrado.");
                    return;
                }

                Veiculo veiculo = buscarVeiculoPorId(veiculoId);
                if (veiculo == null) {
                    JOptionPane.showMessageDialog(frame, "Erro ao realizar loca��o: Ve�culo n�o encontrado.");
                    return;
                }

                if (!veiculo.isDisponivel()) {
                    JOptionPane.showMessageDialog(frame, "Erro ao realizar loca��o: Ve�culo n�o est� dispon�vel.");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dataInicio = sdf.parse(dataInicioStr);
                Date dataFim = sdf.parse(dataFimStr);
                Locacao locacao = new Locacao(id, cliente, veiculo, dataInicio, dataFim, valorTotal);
                locacoes.add(locacao);
                veiculo.setDisponivel(false);
                JOptionPane.showMessageDialog(frame, "Loca��o realizada com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao realizar loca��o: IDs devem ser n�meros inteiros e Valor Total deve ser um n�mero.");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao realizar loca��o: Datas devem estar no formato yyyy-MM-dd.");
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