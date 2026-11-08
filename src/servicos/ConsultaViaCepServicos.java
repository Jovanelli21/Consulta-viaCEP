package servicos;

import br.com.via.cep.consulta.EnderecoViaCepRecord;
import exception.CepNaoEncontradoException;
import com.google.gson.Gson;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;

public class ConsultaViaCepServicos {
    
    //Busca de endereço
    public EnderecoViaCepRecord buscaEndereco(String cep){
        //Remoção de caracteres especiais
        String cepAjustado = cep.replace("\\D", "");
        
        //Criação da URL
        String urlApi = "https://viacep.com.br/ws/" + cepAjustado + "/json/";
        
        //Criação do cliente
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder(URI.create(urlApi)).GET().build();
        
        try{
            //Envio do pedido para a API, e retorno da respota como String
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
            String json = resposta.body();
            
            //Verifica se a API devolveu indicação de CEP existente
            if (json.contains("\"erro\": \"true\"") || json.contains("\"erro\": true")){
                throw new CepNaoEncontradoException("O CEP informado não foi localizado na base dos Correios.");
            }
            
            //Convertendo o Json
            return new Gson().fromJson(json, EnderecoViaCepRecord.class);
            
        }catch(IOException | InterruptedException e){
            if(e instanceof InterruptedException){
                Thread.currentThread().interrupt();
            }
            throw new RuntimeException("Erro ao consultar viaCep: " + e.getMessage());
        }
    }
}

