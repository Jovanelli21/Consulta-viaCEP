package servicos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {
    //Função para criação do Json
    public void salvaJson(List<?> listaEndereco, String nomeArquivo){
        //Configuração Json com identação.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try(FileWriter escritor = new FileWriter(nomeArquivo + ".json")){
            gson.toJson(listaEndereco, escritor);
        }catch (IOException e){
            throw new RuntimeException("Erro ao escrever Json: " + e.getMessage());
        }
    }
}
