package br.com.zupacademy.maxley.transacao.repository;

import br.com.zupacademy.maxley.transacao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
