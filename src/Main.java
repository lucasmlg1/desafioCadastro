import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws PetException {
        Scanner sc = new Scanner(System.in);

        List<Pet> pets = new ArrayList<>();

        CriarMenu menu = new CriarMenu();
        menu.executarMenu(sc, pets);

        sc.close();
    }
}
