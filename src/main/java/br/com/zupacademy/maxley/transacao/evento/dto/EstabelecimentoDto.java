package br.com.zupacademy.maxley.transacao.evento.dto;

import br.com.zupacademy.maxley.transacao.model.Estabelecimento;

public class EstabelecimentoDto {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoDto(){}

    public EstabelecimentoDto(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "EstabelecimentoDto{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
