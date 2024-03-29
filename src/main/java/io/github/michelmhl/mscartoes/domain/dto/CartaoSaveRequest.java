package io.github.michelmhl.mscartoes.domain.dto;

import io.github.michelmhl.mscartoes.domain.enumeration.BandeiraCartao;
import io.github.michelmhl.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limiteBasico);
    }
}
