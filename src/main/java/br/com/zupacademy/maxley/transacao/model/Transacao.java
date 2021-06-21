package br.com.zupacademy.maxley.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Transacao {
    @Id @Column(length = 100)
    private String id;
    @NotNull
    private BigDecimal valor;
    @NotNull @ManyToOne
    private Estabelecimento estabelecimento;
    @NotNull @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Transacao(){}

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao
    ) {

        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                '}';
    }
}
