package main;

import br.com.via.cep.consulta.EnderecoViaCepRecord;
import exception.CepNaoEncontradoException;
import modelo.Endereco;
import servicos.ConsultaViaCepServicos;
import servicos.GeradorDeArquivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaViaCepServicos consultaCep = new ConsultaViaCepServicos();
        GeradorDeArquivo gerador = new GeradorDeArquivo();
        List<Endereco> enderecos = new ArrayList<>();

        String busca = "";

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um CEP para consulta (ou 'sair' para finalizar):");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                // 1. Busca os dados brutos via API (DTO / Record)
                EnderecoViaCepRecord record = consultaCep.buscaEndereco(busca);
                
                // 2. Converte para o modelo de domínio (Endereco)
                Endereco endereco = new Endereco(record);
                enderecos.add(endereco);

                System.out.println("\n--- Endereço Encontrado ---");
                System.out.println(endereco);
                System.out.println("---------------------------\n");

            } catch (CepNaoEncontradoException e) {
                System.out.println("Atenção: " + e.getMessage() + "\n");
            } catch (RuntimeException e) {
                System.out.println("Erro na execução: " + e.getMessage() + "\n");
            }
        }

        // Salva a lista no arquivo JSON caso tenha ao menos uma consulta válida
        if (!enderecos.isEmpty()) {
            gerador.salvaJson(enderecos, "enderecos_consultados");
            System.out.println("Arquivo 'enderecos_consultados.json' gerado com sucesso contendo " 
                    + enderecos.size() + " registro(s).");
        }

        System.out.println("Aplicação encerrada.");
        leitura.close();
    }
}