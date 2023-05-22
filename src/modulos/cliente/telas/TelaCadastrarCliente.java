package modulos.cliente.telas;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaCadastrarCliente extends JFrame {
    // componentes do painel para os dados do cliente
    private JLabel labelNome;
    private JTextField campoNome;
    public JLabel labelErroNome;

    private JLabel labelTelefone;
    private JTextField campoTelefone;
    public JLabel labelErroTelefone;

    private JLabel labelResidencia;
    private JTextField campoResidencia;
    public JLabel labelErroResidencia;

    public JButton botaoVoltarPaienelCliente;

    public JPanel painelDadosDoCliente;

    // componentes do painel para os dados do contrato
    private JLabel labelDataInicioContrato;
    private JTextField campoDataInicioContrato;
    public JLabel labelErroDataInicioContrato;

    private JLabel labelEstadoContrato;
    public JRadioButton radioButtonAtivo;
    public JRadioButton radioButtonDesativado;
    private ButtonGroup buttonGroupEstadoContrato;

    private JLabel labelDataTerminoContrato;
    private JTextField campoDataTerminoContrato;
    public JLabel labelErroDataTerminoContrato;

    private JLabel labelTipoContrato;
    private JComboBox<String> comboBoxTipoContrato;
    public JLabel labelErroTipoContrato;

    private JLabel labelFormaPagamento;
    private JComboBox<String> comboBoxFormaPagamento;
    public JLabel labelErroFormaPagamento;
    public JButton botaoVoltarPaienelContrato;
    public JButton botaoSalvar;

    public JPanel painelDadosDoContrato;

    public JTabbedPane tabbedPane;

    public TelaCadastrarCliente() {
        tabbedPane = new JTabbedPane();

        // painel dos dados do cliente
        painelDadosDoCliente = new JPanel();

        painelDadosDoCliente.setLayout(new GridLayout(7, 2, 5, 5));
        painelDadosDoCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        labelNome = new JLabel("Nome *");
        campoNome = new JTextField(20);
        labelErroNome = new JLabel();

        painelDadosDoCliente.add(labelNome);
        painelDadosDoCliente.add(campoNome);
        painelDadosDoCliente.add(new JLabel());
        painelDadosDoCliente.add(labelErroNome);

        labelResidencia = new JLabel("residencia *");
        campoResidencia = new JTextField(20);
        labelErroResidencia = new JLabel();

        painelDadosDoCliente.add(labelResidencia);
        painelDadosDoCliente.add(campoResidencia);
        painelDadosDoCliente.add(new JLabel());
        painelDadosDoCliente.add(labelErroResidencia);

        labelTelefone = new JLabel("telefone *");
        campoTelefone = new JTextField(20);
        labelErroTelefone = new JLabel();

        painelDadosDoCliente.add(labelTelefone);
        painelDadosDoCliente.add(campoTelefone);
        painelDadosDoCliente.add(new JLabel());
        painelDadosDoCliente.add(labelErroTelefone);

        botaoSalvar = new JButton("Salvar");
        botaoVoltarPaienelCliente = new JButton("Voltar");
        botaoSalvar.setEnabled(false);

        painelDadosDoCliente.add(botaoVoltarPaienelCliente);
        painelDadosDoCliente.add(new JLabel());

        tabbedPane.addTab("cliente", painelDadosDoCliente);

        // painel dados do contrato
        painelDadosDoContrato = new JPanel();

        painelDadosDoContrato.setLayout(new GridLayout(11, 2, 5, 5));
        painelDadosDoContrato.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        labelDataInicioContrato = new JLabel("Início (dd/mm/aaaa)");
        campoDataInicioContrato = new JTextField(50);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = LocalDate.now().format(formatters);

        campoDataInicioContrato.setText(data);
        labelErroDataInicioContrato = new JLabel();

        painelDadosDoContrato.add(labelDataInicioContrato);
        painelDadosDoContrato.add(campoDataInicioContrato);
        painelDadosDoContrato.add(new JLabel());
        painelDadosDoContrato.add(labelErroDataInicioContrato);

        labelDataTerminoContrato = new JLabel("Término (dd/mm/aaaa)");
        campoDataTerminoContrato = new JTextField(20);
        labelErroDataTerminoContrato = new JLabel();

        painelDadosDoContrato.add(labelDataTerminoContrato);
        painelDadosDoContrato.add(campoDataTerminoContrato);
        painelDadosDoContrato.add(new JLabel());
        painelDadosDoContrato.add(labelErroDataTerminoContrato);

        labelTipoContrato = new JLabel("Tipo"); // combobox
        comboBoxTipoContrato = new JComboBox<>();
        DefaultComboBoxModel<String> tipoDeContratoComboBoxModel = new DefaultComboBoxModel<>();

        tipoDeContratoComboBoxModel.addElement("residencial");
        tipoDeContratoComboBoxModel.addElement("comercial");

        comboBoxTipoContrato.setModel(tipoDeContratoComboBoxModel);

        labelErroTipoContrato = new JLabel();

        painelDadosDoContrato.add(labelTipoContrato);
        painelDadosDoContrato.add(comboBoxTipoContrato);
        painelDadosDoContrato.add(new JLabel());
        painelDadosDoContrato.add(labelErroTipoContrato);

        labelFormaPagamento = new JLabel("Forma de Pagamento:"); // combobox
        comboBoxFormaPagamento = new JComboBox<>();

        DefaultComboBoxModel<String> formaDePagamentocomboBoxModel = new DefaultComboBoxModel<>();

        formaDePagamentocomboBoxModel.addElement("taxa unica");
        formaDePagamentocomboBoxModel.addElement("taxa consumo");

        comboBoxFormaPagamento.setModel(formaDePagamentocomboBoxModel);

        labelErroFormaPagamento = new JLabel();

        painelDadosDoContrato.add(labelFormaPagamento);
        painelDadosDoContrato.add(comboBoxFormaPagamento);
        painelDadosDoContrato.add(new JLabel());
        painelDadosDoContrato.add(labelErroFormaPagamento);

        labelEstadoContrato = new JLabel("Estado do Contrato:");
        radioButtonAtivo = new JRadioButton("Ativo");
        radioButtonAtivo.setSelected(true);
        radioButtonDesativado = new JRadioButton("encerado");
        radioButtonDesativado.setEnabled(false);

        buttonGroupEstadoContrato = new ButtonGroup();
        buttonGroupEstadoContrato.add(radioButtonAtivo);
        buttonGroupEstadoContrato.add(radioButtonDesativado);

        painelDadosDoContrato.add(labelEstadoContrato);
        painelDadosDoContrato.add(radioButtonAtivo);
        painelDadosDoContrato.add(new JLabel());
        painelDadosDoContrato.add(radioButtonDesativado);

        botaoVoltarPaienelContrato = new JButton("voltar");

        painelDadosDoContrato.add(botaoVoltarPaienelContrato);
        painelDadosDoContrato.add(botaoSalvar);

        tabbedPane.addTab("contrato", painelDadosDoContrato);

        add(tabbedPane);

        getRootPane().setDefaultButton(botaoSalvar);

        setTitle("cadastrar cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(420, 320);
        setLocationRelativeTo(null);
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoTelefone() {
        return campoTelefone;
    }

    public JTextField getCampoResidencia() {
        return campoResidencia;
    }

    public String getNome() {
        return campoNome.getText();
    }

    public String getTelefone() {
        return campoTelefone.getText();
    }

    public String getResidencia() {
        return campoResidencia.getText();
    }

    public JTextField getCampoDataInicioContrato() {
        return campoDataInicioContrato;
    }

    public String getDataInicioContrato() {
        return campoDataInicioContrato.getText();
    }

    public JTextField getCampoDataTerminoContrato() {
        return campoDataTerminoContrato;
    }

    public String getDataTerminoContrato() {
        return campoDataTerminoContrato.getText();
    }

    public JComboBox<String> getComboBoxTipoContrato() {
        return comboBoxTipoContrato;
    }

    public String getTipoContrato() {
        return (String) comboBoxTipoContrato.getSelectedItem();
    }

    public JComboBox<String> getComboBoxFormaPagamento() {
        return comboBoxFormaPagamento;
    }

    public String getFormaPagamento() {
        return (String) comboBoxFormaPagamento.getSelectedItem();
    }

    public boolean getEstadoContrato() {
        if (radioButtonAtivo.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
}
