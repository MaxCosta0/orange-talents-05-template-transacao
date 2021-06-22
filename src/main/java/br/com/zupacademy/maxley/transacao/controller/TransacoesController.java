package br.com.zupacademy.maxley.transacao.controller;

import br.com.zupacademy.maxley.transacao.controller.dto.TransacaoResponse;
import br.com.zupacademy.maxley.transacao.model.Cartao;
import br.com.zupacademy.maxley.transacao.model.Transacao;
import br.com.zupacademy.maxley.transacao.repository.CartaoRepository;
import br.com.zupacademy.maxley.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
public class TransacoesController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping(value = "/transacoes/cartoes/{idCartao}")
    public ResponseEntity<?> ultimasTransacoes(@PathVariable("idCartao") String idCartao,
                                               @PageableDefault(sort = "efetivadaEm",
                                                       direction = Sort.Direction.DESC,
                                                       page = 0, size = 10)
                                                       Pageable paginacao){

        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);

        if(cartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Page<Transacao> transacoes = transacaoRepository.findByCartao(cartao.get(), paginacao);

        return ResponseEntity.ok().body(TransacaoResponse.toResponse(transacoes));
    }
}
