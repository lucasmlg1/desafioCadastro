import java.util.List;
import java.util.Scanner;

public class CriarMenu {

        public void executarMenu(Scanner sc, List<Pet> pets){
            LerFormulario lerFormulario = new LerFormulario();
            String i;
            int op = 0;

        do {
            System.out.println("\nInsira uma das opções abaixo:");
            System.out.println("1 - Cadastrar um novo pet");
            System.out.println("2 - Alterar os dados do pet cadastrado");
            System.out.println("3 - Deletar um pet cadastrado");
            System.out.println("4 - Listar todos os pets cadastrados");
            System.out.println("5 - Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            i = sc.nextLine().trim();

            if (!i.matches("\\d+")){
                System.out.println("Digite apenas números");
                continue;
            }
            op = Integer.parseInt(i);
            if (op<=0 || op>6){
                System.out.println("Digite um número válido (1 a 6), por favor.");
                continue;
            }

            switch (op) {
                case 1:
                    try {
                        Pet pet = lerFormulario.criarFormulario(sc);
                        pets.add(pet);
                        System.out.println("Pet cadastrado com sucesso! Total: " + pets.size());
                    } catch (PetException e) {
                        System.out.println("Erro no cadastro: " + e.getMessage());
                    }
                    break;

                case 2: /* ... */ break;
                case 3: /* ... */ break;

                case 4:
                    if (pets.isEmpty()) {
                        System.out.println("Nenhum pet cadastrado.");
                    } else {
                        for (int indice = 0; indice < pets.size(); indice++) {
                            Pet p = pets.get(indice);
                            System.out.println((indice + 1) + " - " + p.getNomeCompleto());
                        }
                    }
                    break;

                case 5: /* ... */ break;
                case 6:
                    System.out.println("Finalizando Cadastro De Pets...");
                    break;
            }


        }while(op != 6);

    }
}

