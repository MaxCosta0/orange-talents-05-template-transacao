package br.com.zupacademy.maxley.transacao.repository;

import br.com.zupacademy.maxley.transacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
