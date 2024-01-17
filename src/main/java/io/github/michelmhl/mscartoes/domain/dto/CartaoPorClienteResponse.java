package io.github.michelmhl.mscartoes.domain.dto;

import io.github.michelmhl.mscartoes.domain.Cartao;
import io.github.michelmhl.mscartoes.domain.ClienteCartao;
import io.github.michelmhl.mscartoes.domain.enumeration.BandeiraCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoPorClienteResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static  CartaoPorClienteResponse fromModel(ClienteCartao model){
        return new CartaoPorClienteResponse(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getCartao().getLimiteBasico()
        );
    }

}
