package br.com.zupacademy.maxley.transacao.evento;

import br.com.zupacademy.maxley.transacao.evento.dto.CartaoDto;
import br.com.zupacademy.maxley.transacao.evento.dto.EstabelecimentoDto;
import br.com.zupacademy.maxley.transacao.model.Cartao;
import br.com.zupacademy.maxley.transacao.model.Estabelecimento;
import br.com.zupacademy.maxley.transacao.model.Transacao;

import java.math.BigDecimal;

public class TransacaoEvento {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoDto estabelecimento;
    private CartaoDto cartao;

    @Deprecated
    public TransacaoEvento(){}

    public TransacaoEvento(String id, BigDecimal valor, EstabelecimentoDto estabelecimento, CartaoDto cartao
    ) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
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

    @Override
    public String toString() {
        return "TransacaoEvento{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
//                ", estabelecimento=" + estabelecimento +
//                ", cartao=" + cartao +
                '}';
    }

    public Transacao toModel(Estabelecimento estabelecimento, Cartao cartao) {
        return new Transacao(id, valor, estabelecimento, cartao);
    }
}
