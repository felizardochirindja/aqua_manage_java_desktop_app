package modulos.autenticacao;

import modulos.usuario.UsuarioEntidade;
import modulos.usuario.administrador.AdministradorArmazenamento;
import modulos.usuario.administrador.AdministradorEntidade;
import modulos.usuario.funcionario.FuncionarioArmazenamento;
import modulos.usuario.funcionario.FuncionarioEntidade;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AutenticacaoArmazenamento {
    FuncionarioArmazenamento funcionarioArmazenamento;
    AdministradorArmazenamento administradorArmazenamento;

    public AutenticacaoArmazenamento(FuncionarioArmazenamento funcionarioArmazenamento, AdministradorArmazenamento administradorArmazenamento) {
        this.funcionarioArmazenamento = funcionarioArmazenamento;
        this.administradorArmazenamento = administradorArmazenamento;
    }

    public AutenticacaoArmazenamento() {}

    public UsuarioEntidade iniciarSessao(String nome, String senha) {
        List<UsuarioEntidade> usuarioEntidades = new ArrayList<>();

        for (AdministradorEntidade administrador: administradorArmazenamento.listar()) {
            usuarioEntidades.add(administrador);
        }

        for (FuncionarioEntidade funcionario: funcionarioArmazenamento.listar()) {
            usuarioEntidades.add(funcionario);
        }

        for (UsuarioEntidade usuarioEntidade : usuarioEntidades) {
            if (usuarioEntidade.getNome().equals(nome) && usuarioEntidade.getSenha().equals(senha)) {
                return usuarioEntidade;
            }
        }

        return null;
    }

    public void armazenarUsuarioLogado(UsuarioEntidade usuario) {
        try{
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\token.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(usuario);

            ficheiro.flush();
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
            e.getStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UsuarioEntidade pegarUsuarioLogado() {
        UsuarioEntidade usuario = null;

        try {
            FileInputStream ficheiro = new FileInputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\token.dat");
            ObjectInputStream in = new ObjectInputStream(ficheiro);

            usuario = (UsuarioEntidade) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            e.getStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
