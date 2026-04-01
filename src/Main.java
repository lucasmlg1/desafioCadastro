import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CriarFormulario formulario = new CriarFormulario();
        formulario.criarFormulario();

        CriarMenu menu = new CriarMenu();
        menu.executarMenu(sc);

        sc.close();
    }
}
