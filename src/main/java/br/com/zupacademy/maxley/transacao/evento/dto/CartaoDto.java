package br.com.zupacademy.maxley.transacao.evento.dto;

import br.com.zupacademy.maxley.transacao.model.Cartao;

public class CartaoDto {

    private String id;
    private String email;

    public CartaoDto(){}

    public CartaoDto(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CartaoDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }
}
