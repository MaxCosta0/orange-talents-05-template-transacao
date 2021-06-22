package br.com.zupacademy.maxley.transacao.evento;

import br.com.zupacademy.maxley.transacao.evento.dto.TransacaoEventoDto;
import br.com.zupacademy.maxley.transacao.model.Cartao;
import br.com.zupacademy.maxley.transacao.model.Estabelecimento;
import br.com.zupacademy.maxley.transacao.model.Transacao;
import br.com.zupacademy.maxley.transacao.repository.CartaoRepository;
import br.com.zupacademy.maxley.transacao.repository.EstabelecimentoRepository;
import br.com.zupacademy.maxley.transacao.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private CartaoRepository cartaoRepository;

    private Logger logger = LoggerFactory.getLogger(TransacaoConsumer.class);

    @Bean
    public JsonMessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }

    @KafkaListener(topics = "transacoes")
    public void ouvir(TransacaoEventoDto transacaoEvento){
        Estabelecimento estabelecimento = transacaoEvento.getEstabelecimento().toModel();
        Cartao cartao = transacaoEvento.getCartao().toModel();
        Transacao transacao = transacaoEvento.toModel(estabelecimento, cartao);

        estabelecimentoRepository.save(estabelecimento);
        cartaoRepository.save(cartao);
        transacaoRepository.save(transacao);

        logger.info(transacao.toString());
    }
}
