import java.io.*;
import java.util.Scanner;

public class LerFormulario {


    public Pet criarFormulario(Scanner sc) throws PetException{
        Pet pet = new Pet();
        Endereco endereco = new Endereco();
        try (FileReader fileReader = new FileReader(("resources/formulario.txt"));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linha;
            int numeroContador=0;

            while ((linha = bufferedReader.readLine()) != null){
                System.out.println(linha);
                numeroContador++;

                if (numeroContador == 4) {
                    System.out.println("Responda as perguntas abaixo sobre o endereço:");
                    System.out.print("Número da casa: ");
                    String numero = sc.nextLine().trim();
                    if (numero.isEmpty()) numero = Pet.NAO_INFORMADO;
                    endereco.setNumeroEndereco(numero);

                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine().trim();
                    endereco.setCidade(cidade.isEmpty() ? Pet.NAO_INFORMADO : cidade);

                    System.out.print("Rua: ");
                    String rua = sc.nextLine().trim();
                    endereco.setRua(rua.isEmpty() ? Pet.NAO_INFORMADO : rua);

                    pet.setEndereco(endereco);
                    continue;
                }

                String resposta = sc.nextLine().trim();

                switch (numeroContador) {
                    case 1:
                        if(resposta.isBlank()){
                            throw new PetException("Nome e sobrenome são obrigatórios");
                        }
                        if (!resposta.matches("[a-zA-ZÀ-ÿ ]+")){
                            throw new PetException("Use apenas letras para responder o Nome.");
                        }

                        String[] partes = resposta.trim().split("\\s+");
                        if(partes.length < 2){
                            throw new PetException("Insira um nome com nome e sobrenome");
                        }
                        pet.setNomeCompleto(resposta); break;
                    case 2:
                        try{
                            pet.setTipo(TipoPet.valueOf(resposta.toUpperCase()));
                        } catch (IllegalArgumentException  e) {
                            throw new PetException("Tipo Inválido, precisa ser CACHORRO OU GATO");
                        } break;
                    case 3:
                        try{
                            pet.setSexo(SexoPet.valueOf(resposta.toUpperCase()));
                    }catch(IllegalArgumentException e){
                        throw new PetException("Tipo inválido, precisa ser MACHO OU FEMEA");
                    } break;
                    case 5:
                        if (resposta.isBlank()) {
                            pet.setIdade(null);
                            break;
                        }
                        double idade;
                        try {
                            idade = Double.parseDouble(resposta.replace(",", "."));
                        } catch (NumberFormatException e) {
                            throw new PetException("Idade: digite apenas números (pode usar vírgula ou ponto).");
                        }

                        if (idade > 20) {throw new PetException("Idade não pode ser maior que 20 anos!");}
                        if (idade < 0) {throw new PetException("Idade não pode ser negativa!");}
                        if (resposta.matches("^\\d+$") && idade >= 1 && idade <= 11) {
                            idade = idade / 12.0;
                        }

                        pet.setIdade(idade);
                        break;
                    case 6:
                        if (resposta.isBlank()) {
                            pet.setPesoKg(null);
                            break;
                        }
                        double peso;
                        try {
                            peso = Double.parseDouble(resposta.replace(",", "."));
                        } catch (NumberFormatException e) {throw new PetException("Peso: digite apenas números (pode usar vírgula ou ponto).");}

                        if (peso > 60 || peso < 0.5) {throw new PetException("Peso inválido. Deve ter entre 0.5kg e 60kg!");}
                        pet.setPesoKg(peso);
                        break;
                    case 7:
                        if (resposta.isBlank()) {
                            pet.setRaca(Pet.NAO_INFORMADO);
                            break;
                        }
                        if (!resposta.matches("[a-zA-ZÀ-ÿ ]+")) {
                            throw new PetException("Raça não pode ter números ou caracteres especiais!");
                        }
                        pet.setRaca(resposta);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Não foi possível ler o formulario.txt");
            e.printStackTrace();
        }
        return pet;
    }

}
