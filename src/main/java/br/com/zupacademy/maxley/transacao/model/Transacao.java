package br.com.zupacademy.maxley.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao(){}

    public Transacao(String id, BigDecimal valor,
                     Estabelecimento estabelecimento,
                     Cartao cartao, LocalDateTime efetivadaEm) {

        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", instanteTransacao=" + efetivadaEm +
                '}';
    }
}
