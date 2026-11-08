package modelo;

import br.com.via.cep.consulta.EnderecoViaCepRecord;

public class Endereco {
    //Atributos
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    
    //Construtor
    public Endereco(EnderecoViaCepRecord enderecoViaCepRecord){
        this.cep = enderecoViaCepRecord.cep();
        this.endereco = enderecoViaCepRecord.endereco();
        this.bairro = enderecoViaCepRecord.bairro();
        this.cidade = enderecoViaCepRecord.cidade();
        this.uf = enderecoViaCepRecord.uf();
    }
    
    //Modificadores
    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    //Acessores

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }
    
    //Metodo ToString
    @Override
    public String toString(){
        return """
               Cep: %s
               Endereco: %s
               Bairro: %s
               Cidade: %s / UF: %s
               """.formatted(cep, endereco, bairro, cidade, uf);
    }
}
