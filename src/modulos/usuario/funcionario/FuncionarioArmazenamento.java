package modulos.usuario.funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioArmazenamento {
    public void criar(List<FuncionarioEntidade> funcionarios) {
        try{
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\funcionarios.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(funcionarios);

            ficheiro.flush();
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
            e.getStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<FuncionarioEntidade> listar() {
        List<FuncionarioEntidade> funcionarios = new ArrayList<>();

        try {
            FileInputStream ficheiro = new FileInputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\funcionarios.dat");
            ObjectInputStream in = new ObjectInputStream(ficheiro);

            funcionarios = (ArrayList<FuncionarioEntidade>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            e.getStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return funcionarios;
    }
}
