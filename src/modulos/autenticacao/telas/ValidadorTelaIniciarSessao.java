package modulos.autenticacao.telas;

public class ValidadorTelaIniciarSessao {
    private ValidadorTelaIniciarSessao() {}

    public static String validarCampoNome(String nome) {
        if (nome.isEmpty()) {
            return "O nome é obrigatório";
        }

        return "";
    }

    public static  String validarCampoPalavraPasse(char[] palavraPasse) {
        if (palavraPasse.length == 0) {
            return "A palavra-passe é obrigatória";
        }

        return  "";
    }
}
