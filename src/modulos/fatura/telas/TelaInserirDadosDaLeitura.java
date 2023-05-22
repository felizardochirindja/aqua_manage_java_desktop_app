package modulos.fatura.telas;

import javax.swing.*;
import java.awt.*;

public class TelaInserirDadosDaLeitura extends JFrame {
    private JLabel labelDataDaLeitura;
    private JTextField campoConsumo;
    public JLabel labelErroDataDaLeitura;

    public JButton botaoConfirmar;
    public JButton botaoCancelar;

    private JPanel painel;

    public TelaInserirDadosDaLeitura() {
        painel = new JPanel();

        painel.setLayout(new GridLayout(3, 2, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        labelDataDaLeitura = new JLabel("data da leitura");
        campoConsumo = new JTextField(20);
        labelErroDataDaLeitura = new JLabel();

        painel.add(labelDataDaLeitura);
        painel.add(campoConsumo);
        painel.add(new JLabel());
        painel.add(labelErroDataDaLeitura);

        botaoCancelar = new JButton("cancelar");
        botaoConfirmar = new JButton("confirmar");
        botaoConfirmar.setEnabled(!getConsumo().isEmpty());

        painel.add(botaoCancelar);
        painel.add(botaoConfirmar);

        add(painel);

        setTitle("inserir dados da fatura");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
    }

    public JTextField getCampoConsumo() {
        return campoConsumo;
    }

    public String getConsumo() {
        return campoConsumo.getText();
    }
}
