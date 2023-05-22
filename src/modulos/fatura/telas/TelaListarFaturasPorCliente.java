package modulos.fatura.telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaListarFaturasPorCliente extends JFrame {
    public JTable tabelaFuncionarios;
    public JButton botaoListarMultas;
    public JButton botaoPagar;
    public JButton botaoImprimir;
    public DefaultTableModel tabelaModelo;

    private JLabel labelValorAPagar;
    private JLabel labelErroValorAPagar;
    private JTextField campoValorAPagar;
    private JPanel painel;

    public boolean tabelaFuncinariosEstaSelecionada = false;

    public TelaListarFaturasPorCliente() {
        painel = new JPanel();

        painel.setLayout(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        tabelaModelo = new DefaultTableModel();
        tabelaModelo.addColumn("cliente");
        tabelaModelo.addColumn("data emissao");
        tabelaModelo.addColumn("tipo de contrato");
        tabelaModelo.addColumn("formas de pagamento");
        tabelaModelo.addColumn("valor a pagar");
        tabelaModelo.addColumn("valor pago");
        tabelaModelo.addColumn("estado");
        tabelaModelo.addColumn("valor em divida");
        tabelaFuncionarios = new JTable(tabelaModelo);

        tabelaModelo.setRowCount(0);

        JScrollPane scrollPane = new JScrollPane(tabelaFuncionarios);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        labelValorAPagar = new JLabel("valor a pagar");
        campoValorAPagar = new JTextField(5);
        campoValorAPagar.setEnabled(false);
        labelErroValorAPagar = new JLabel();
        botoesPanel.add(labelErroValorAPagar);
        botoesPanel.add(labelValorAPagar);
        botoesPanel.add(campoValorAPagar);

        botaoPagar = new JButton("pagar");
        botaoPagar.setEnabled(false);
        botoesPanel.add(botaoPagar);

        botaoListarMultas = new JButton("listar multas");
        botaoListarMultas.setEnabled(false);
        botoesPanel.add(botaoListarMultas);

        botaoImprimir = new JButton("imprimir");
        botaoImprimir.setEnabled(false);
        botoesPanel.add(botaoImprimir);

        painel.add(scrollPane, BorderLayout.CENTER);
        painel.add(botoesPanel, BorderLayout.SOUTH);

        add(painel);

        setTitle("listar faturas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
    }

    public JTextField getCampoValorAPagar() {
        return campoValorAPagar;
    }

    public String getValorAPagar() {
        return campoValorAPagar.getText();
    }
}
