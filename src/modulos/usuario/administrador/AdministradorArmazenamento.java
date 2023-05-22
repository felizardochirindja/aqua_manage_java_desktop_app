package modulos.usuario.administrador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorArmazenamento {
    public void criar(AdministradorEntidade administrador) {
        List<AdministradorEntidade> administradores = listar();
        administradores.add(administrador);

        try{
            FileOutputStream ficheiro = new FileOutputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\administradores.dat");
            ObjectOutputStream os = new ObjectOutputStream(ficheiro);

            os.writeObject(administradores);

            ficheiro.flush();
            ficheiro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao localizado");
            e.getStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<AdministradorEntidade> listar() {
        List<AdministradorEntidade> administradores = new ArrayList<>();

        try {
            FileInputStream ficheiro = new FileInputStream("C:\\xampp\\htdocs\\my_space\\java\\uemJobFinal\\src\\ficheiros\\administradores.dat");
            ObjectInputStream in = new ObjectInputStream(ficheiro);

            administradores = (ArrayList<AdministradorEntidade>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
            e.getStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return administradores;
    }
}
