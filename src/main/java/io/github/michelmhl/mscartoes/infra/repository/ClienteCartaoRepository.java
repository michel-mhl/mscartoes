package io.github.michelmhl.mscartoes.infra.repository;

import io.github.michelmhl.mscartoes.domain.Cartao;
import io.github.michelmhl.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao , Long> {
    List<ClienteCartao> findByCpf(String cpf);
}
