package modulos.usuario.administrador.telas;

import javax.swing.*;
import java.awt.*;

public class TelaCadastrarAdministrador extends JFrame {
    private JLabel labelNome;
    private JTextField campoNome;
    public JLabel labelErroNome;

    private JLabel labelPalavraPasse;
    private JTextField campoPalavraPasse;
    public JLabel labelErroPalavraPasse;

    private JLabel labelTelefone;
    private JTextField campoTelefone;
    public JLabel labelErroTelefone;

    private JLabel labelEndereco;
    private JTextField campoEndereco;
    public JLabel labelErroEndereco;

    public JButton botaoSalvar;

    public boolean valido;

    private JPanel painel;

    public TelaCadastrarAdministrador() {
        painel = new JPanel();

        painel.setLayout(new GridLayout(9, 2, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        labelNome = new JLabel("Nome *");
        campoNome = new JTextField(20);
        labelErroNome = new JLabel();

        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(new JLabel());
        painel.add(labelErroNome);

        labelPalavraPasse = new JLabel("palavra-passe *");
        campoPalavraPasse = new JTextField(20);
        labelErroPalavraPasse = new JLabel();

        painel.add(labelPalavraPasse);
        painel.add(campoPalavraPasse);
        painel.add(new JLabel());
        painel.add(labelErroPalavraPasse);

        labelTelefone = new JLabel("Telefone *");
        campoTelefone = new JTextField(20);
        labelErroTelefone = new JLabel();

        painel.add(labelTelefone);
        painel.add(campoTelefone);
        painel.add(new JLabel());
        painel.add(labelErroTelefone);

        labelEndereco = new JLabel("Endereço *");
        campoEndereco = new JTextField(20);
        labelErroEndereco = new JLabel();

        painel.add(labelEndereco);
        painel.add(campoEndereco);
        painel.add(new JLabel());
        painel.add(labelErroEndereco);

        botaoSalvar = new JButton("Salvar");

        painel.add(new JLabel());
        painel.add(botaoSalvar);

        botaoSalvar.setEnabled(false);

        add(painel);

        getRootPane().setDefaultButton(botaoSalvar);
        setTitle("cadastrar administrador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoPalavraPasse() {
        return campoPalavraPasse;
    }

    public JTextField getCampoTelefone() {
        return campoTelefone;
    }

    public JTextField getCampoEndereco() {
        return campoEndereco;
    }

    public String getNome() {
        return campoNome.getText();
    }

    public String getPalavraPasse() throws NumberFormatException {
        return campoPalavraPasse.getText();
    }

    public String getTelefone() {
        return campoTelefone.getText();
    }

    public String getEndereco() {
        return campoEndereco.getText();
    }
}
