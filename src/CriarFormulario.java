import java.io.*;

public class CriarFormulario {
    public void criarFormulario(){
        try (FileReader fileReader = new FileReader(("resources/formulario.txt"));
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String linha;
            while ((linha = bufferedReader.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Não foi possível ler o formulario.txt");
            e.printStackTrace();
        }
    }
}
