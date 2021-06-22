package br.com.zupacademy.maxley.transacao.controller.dto;

import br.com.zupacademy.maxley.transacao.model.Cartao;
import br.com.zupacademy.maxley.transacao.model.Estabelecimento;
import br.com.zupacademy.maxley.transacao.model.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class TransacaoResponse {
    private String id;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoResponse(){}

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento();
        this.cartao = transacao.getCartao();
        this.efetivadaEm = transacao.getEfetivadaEm();
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

    public static Page<TransacaoResponse> toResponse(Page<Transacao> transacoes){
        return transacoes.map(TransacaoResponse::new);
    }
}
