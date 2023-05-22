package modulos.usuario.administrador.painel;

import javax.swing.*;
import java.awt.*;

public class TelaPainelAdminstrador extends JFrame {
    public JButton botaoListarClientes;
    public JButton botaoCadastrarCliente;
    public JButton botaoCadastrarFuncionario;
    private JPanel painel;

    public TelaPainelAdminstrador() {
        painel = new JPanel();
        painel.setLayout(new GridLayout(2, 1, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        botaoListarClientes = new JButton("Listar Clientes");
        botaoCadastrarCliente = new JButton("Cadastrar cliente");
        botaoCadastrarFuncionario = new JButton("Cadastrar funcionario");

        painel.add(botaoListarClientes);
        painel.add(botaoCadastrarCliente);
        painel.add(botaoCadastrarFuncionario);

        add(painel);

        setTitle("painel do administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
    }
}
