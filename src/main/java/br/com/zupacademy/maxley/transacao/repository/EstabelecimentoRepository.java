package br.com.zupacademy.maxley.transacao.repository;

import br.com.zupacademy.maxley.transacao.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
}
