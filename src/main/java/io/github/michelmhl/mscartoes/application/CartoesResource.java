package io.github.michelmhl.mscartoes.application;

import io.github.michelmhl.mscartoes.application.service.CartaoService;
import io.github.michelmhl.mscartoes.application.service.ClienteCartaoService;
import io.github.michelmhl.mscartoes.domain.Cartao;
import io.github.michelmhl.mscartoes.domain.ClienteCartao;
import io.github.michelmhl.mscartoes.domain.dto.CartaoPorClienteResponse;
import io.github.michelmhl.mscartoes.domain.dto.CartaoSaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
public class CartoesResource {

    @Autowired
    private CartaoService service;
    @Autowired
    private ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastro(@RequestBody CartaoSaveRequest request) {
        Cartao cartao = request.toModel();
        service.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda) {
        List<Cartao> list = service.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartaoPorClienteResponse>> getCartaoByCliente( @RequestParam ("cpf") String cpf){
     List<ClienteCartao> lista =   clienteCartaoService.listCartoesByCpf(cpf);
     List<CartaoPorClienteResponse> resultList = lista.stream()
             .map(CartaoPorClienteResponse :: fromModel)
             .collect(Collectors.toList());
     return ResponseEntity.ok(resultList);
    }
}
