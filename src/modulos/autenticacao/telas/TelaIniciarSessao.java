package modulos.autenticacao.telas;

import javax.swing.*;
import java.awt.*;

public class TelaIniciarSessao extends JFrame {
    private JLabel userNameLabel;
    private JTextField campoNome;
    public JLabel labelErroNome;
    private JLabel passwordLabel;
    private JPasswordField campoPalavraPasse;
    public JLabel labelErroPalavraPasse;
    public JButton botaoCancelar;
    public JButton botaoEntrar;
    private JPanel panel;
    public TelaIniciarSessao() {
        panel = new JPanel();

        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        userNameLabel = new JLabel("usuario *");
        campoNome = new JTextField(10);
        labelErroNome = new JLabel();

        panel.add(userNameLabel);
        panel.add(campoNome);
        panel.add(new JLabel());
        panel.add(labelErroNome);

        passwordLabel = new JLabel("palavra-passe *");
        campoPalavraPasse = new JPasswordField(10);
        labelErroPalavraPasse = new JLabel();

        panel.add(passwordLabel);
        panel.add(campoPalavraPasse);
        panel.add(new JLabel());
        panel.add(labelErroPalavraPasse);

        botaoCancelar = new JButton("cancelar");
        botaoEntrar = new JButton("entrar");

        panel.add(botaoCancelar);
        panel.add(botaoEntrar);

        botaoEntrar.setEnabled(false);

        add(panel);

        getRootPane().setDefaultButton(botaoEntrar);
        setTitle("Iniciar sessao");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 215);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JPasswordField getCampoPalavraPasse() {
        return campoPalavraPasse;
    }

    public String getNome() {
        return campoNome.getText();
    }

    public char[] getPalavraPasse() {
        return campoPalavraPasse.getPassword();
    }
}
