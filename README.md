# 📍 Consulta ViaCEP - Java

Aplicação Java desenvolvida para realizar consultas de endereços consumindo a API Web do [ViaCEP](https://viacep.com.br/), com desserialização JSON via Gson, tratamento de exceções personalizadas e exportação de resultados em arquivo estruturado.

## 🛠️ Tecnologias Utilizadas
* **Java** (HttpClient nativo, Records, Text Blocks)
* **Gson** (Mapeamento DTO e gravação formatada)
* **Git / GitHub**

## 🏗️ Estrutura do Projeto
O projeto foi organizado separando as responsabilidades em pacotes dedicados:

- `br.com.via.cep.consulta`: DTO (`EnderecoViaCepRecord`) para mapear os dados recebidos da API com `@SerializedName`.
- `modelo`: Classe de domínio (`Endereco`) com formatação interna e sobrescrita do `toString()`.
- `servicos`: Lógica de requisição HTTP (`ConsultaViaCep`) e persistência em arquivo (`GeradorDeArquivo`).
- `exception`: Tratamento de exceção de negócio (`CepNaoEncontradoException`).
- `main`: Execução principal com menu iterativo no terminal (`Principal`).

## 🚀 Como Executar
1. Clone o repositório:
   ```bash
   git clone [https://github.com/Jovanelli21/ConsultaViaCep.git](https://github.com/Jovanelli21/ConsultaViaCep.git)
