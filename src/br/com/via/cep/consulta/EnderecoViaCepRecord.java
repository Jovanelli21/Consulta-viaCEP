package br.com.via.cep.consulta;

import com.google.gson.annotations.SerializedName;

public record EnderecoViaCepRecord (
        //Variaveis para tratamento do Json
        @SerializedName("cep") String cep,
        @SerializedName("logradouro") String endereco,
        @SerializedName("complemento") String complemento,
        @SerializedName("bairo") String bairro,
        @SerializedName("localidade") String cidade,
        @SerializedName("uf") String uf
        )

{}
