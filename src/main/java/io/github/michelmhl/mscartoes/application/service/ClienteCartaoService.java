package io.github.michelmhl.mscartoes.application.service;

import io.github.michelmhl.mscartoes.domain.Cartao;
import io.github.michelmhl.mscartoes.domain.ClienteCartao;
import io.github.michelmhl.mscartoes.infra.repository.CartaoRepository;
import io.github.michelmhl.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {


    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
           return repository.findByCpf(cpf);
    }
}
