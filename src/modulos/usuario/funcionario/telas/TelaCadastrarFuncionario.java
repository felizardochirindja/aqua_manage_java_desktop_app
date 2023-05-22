package modulos.usuario.funcionario.telas;

import javax.swing.*;
import java.awt.*;

public class TelaCadastrarFuncionario extends JFrame {
    private JLabel labelNome;
    private JTextField campoNome;
    public JLabel labelErroNome;

    private JLabel labelIdade;
    private JTextField campoIdade;
    public JLabel labelErroIdade;

    private JLabel labelTelefone;
    private JTextField campoTelefone;
    public JLabel labelErroTelefone;

    private JLabel labelDataAdmissao;
    private JTextField campoDataAdmissao;
    public JLabel labelErroDataAdmissao;

    private JLabel labelEndereco;
    private JTextField campoEndereco;
    public JLabel labelErroEndereco;

    private JLabel labelPalavraPasse;
    private JTextField campoPalavraPasse;
    public JLabel labelErroPalavraPasse;

    public JButton botaoSalvar;
    public JButton botaoVoltar;
    public boolean valido;
    private JPanel painel;

    public TelaCadastrarFuncionario() {
        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(13, 2, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        labelNome = new JLabel("Nome *");
        campoNome = new JTextField(20);
        labelErroNome = new JLabel();

        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(new JLabel());
        painel.add(labelErroNome);

        labelIdade = new JLabel("Idade *");
        campoIdade = new JTextField(20);
        labelErroIdade = new JLabel();

        painel.add(labelIdade);
        painel.add(campoIdade);
        painel.add(new JLabel());
        painel.add(labelErroIdade);

        labelTelefone = new JLabel("Telefone *");
        campoTelefone = new JTextField(20);
        labelErroTelefone = new JLabel();

        painel.add(labelTelefone);
        painel.add(campoTelefone);
        painel.add(new JLabel());
        painel.add(labelErroTelefone);

        labelDataAdmissao = new JLabel("Data de Admissão (dd/mm/aaaa):");
        campoDataAdmissao = new JTextField(20);
        labelErroDataAdmissao = new JLabel();

        painel.add(labelDataAdmissao);
        painel.add(campoDataAdmissao);
        painel.add(new JLabel());
        painel.add(labelErroDataAdmissao);

        labelEndereco = new JLabel("Endereço *");
        campoEndereco = new JTextField(20);
        labelErroEndereco = new JLabel();

        painel.add(labelEndereco);
        painel.add(campoEndereco);
        painel.add(new JLabel());
        painel.add(labelErroEndereco);

        labelPalavraPasse = new JLabel("palavra-passe *");
        campoPalavraPasse = new JTextField(20);
        labelErroPalavraPasse = new JLabel();

        painel.add(labelPalavraPasse);
        painel.add(campoPalavraPasse);
        painel.add(new JLabel());
        painel.add(labelErroPalavraPasse);

        botaoSalvar = new JButton("Salvar");
        botaoVoltar = new JButton("voltar");

        painel.add(botaoVoltar);
        painel.add(botaoSalvar);

        botaoSalvar.setEnabled(false);

        add(painel);

        getRootPane().setDefaultButton(botaoSalvar);
        setTitle("cadastrar funcionario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoIdade() {
        return campoIdade;
    }

    public JTextField getCampoTelefone() {
        return campoTelefone;
    }

    public JTextField getCampoDataAdmissao() {
        return campoDataAdmissao;
    }

    public JTextField getCampoEndereco() {
        return campoEndereco;
    }

    public String getNome() {
        return campoNome.getText();
    }

    public String getIdade() throws NumberFormatException {
        return campoIdade.getText();
    }

    public String getTelefone() {
        return campoTelefone.getText();
    }

    public JTextField getCampoPalavraPasse() {
        return campoPalavraPasse;
    }

    public String getPalavraPasse() {
        return campoPalavraPasse.getText();
    }

    public String getDataAdmissao() {
        return campoDataAdmissao.getText();
    }

    public String getEndereco() {
        return campoEndereco.getText();
    }
}
