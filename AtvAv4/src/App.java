import java.util.Scanner;

public class App {

    public static String avaliarSenha(String senha) {
        if (senha.length() < 8) {
            return "DICA: A senha deve ter no minimo 8 caracteres.";
        }

        boolean temNumero = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                temNumero = true;
                break;
            }
        }
        if (!temNumero) {
            return "DICA: Adicione pelo menos um número à sua senha.";
        }

        if (senha.equals("12345678") || senha.equals("senha123") || senha.equals("admin123")) {
            return "ALERTA: Esta senha é muito comum ou óbvia.";
        }

        boolean temMaiuscula = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isUpperCase(senha.charAt(i))) {
                temMaiuscula = true;
                break;
            }
        }
        if (!temMaiuscula) {
            return "DICA: Adicione pelo menos uma letra maiúscula à sua senha.";
        }

        return "SUCESSO: Sua senha passou nos critérios básicos!";
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String resultado = "";

        while (!resultado.startsWith("SUCESSO")) {
            System.out.print("Digite uma senha para avaliação: ");
            resultado = avaliarSenha(leitor.nextLine());
            System.out.println(resultado + "\n");
        }

        leitor.close();
    }
}

