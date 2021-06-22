package br.com.zupacademy.maxley.transacao.evento.dto;

import br.com.zupacademy.maxley.transacao.model.Cartao;
import br.com.zupacademy.maxley.transacao.model.Estabelecimento;
import br.com.zupacademy.maxley.transacao.model.Transacao;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoEventoDto {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoDto estabelecimento;
    private CartaoDto cartao;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoEventoDto(){}

    public TransacaoEventoDto(String id, BigDecimal valor,
                              EstabelecimentoDto estabelecimento,
                              CartaoDto cartao, LocalDateTime instanteTransacao) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = instanteTransacao;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDto getCartao() {
        return cartao;
    }

    public LocalDateTime getInstanteTransacao() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "TransacaoEventoDto{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", instanteTransacao=" + efetivadaEm +
                '}';
    }

    public Transacao toModel(Estabelecimento estabelecimento, Cartao cartao) {
        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }
}
