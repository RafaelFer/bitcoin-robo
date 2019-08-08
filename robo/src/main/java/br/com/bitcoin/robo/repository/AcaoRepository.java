package br.com.bitcoin.robo.repository;

import br.com.bitcoin.robo.modelo.Acao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcaoRepository extends JpaRepository<Acao, Long> {

    List<Acao> findAll();

}
