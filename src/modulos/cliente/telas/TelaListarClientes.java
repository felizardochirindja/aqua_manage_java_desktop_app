package modulos.cliente.telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaListarClientes extends JFrame {
    public JTable tabelaClientes;
    public JButton botaoGerarFatura;
    public JButton botaoListarFaturas;
    public JButton botaoActualizar;
    public DefaultTableModel tabelaModelo;
    public JPanel botoesPanel;
    private JPanel painel;

    public TelaListarClientes() {
        painel = new JPanel();

        painel.setLayout(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        tabelaModelo = new DefaultTableModel();
        tabelaModelo.addColumn("Nome");
        tabelaModelo.addColumn("Residência");
        tabelaModelo.addColumn("Telefone");
        tabelaModelo.addColumn("tipo de contrato");
        tabelaModelo.addColumn("formas de pagamento");
        tabelaModelo.addColumn("estado do contrato");
        tabelaClientes = new JTable(tabelaModelo);

        tabelaModelo.setRowCount(0);

        JScrollPane scrollPane = new JScrollPane(tabelaClientes);

        botoesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        botaoListarFaturas = new JButton("Listar Faturas");
        botaoListarFaturas.setEnabled(false);
        botoesPanel.add(botaoListarFaturas);

        botaoGerarFatura = new JButton("Gerar Fatura");
        botaoGerarFatura.setEnabled(false);
        botoesPanel.add(botaoGerarFatura);

        botaoActualizar = new JButton("actualizar");
        botaoActualizar.setEnabled(false);
        botoesPanel.add(botaoActualizar);

        painel.add(scrollPane, BorderLayout.CENTER);
        painel.add(botoesPanel, BorderLayout.SOUTH);

        add(painel);

        setTitle("listar clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(850, 600);
        setLocationRelativeTo(null);
    }
}
