package br.com.leangua.pagamento.controllers;

import br.com.leangua.pagamento.dtos.*;
import br.com.leangua.pagamento.models.Pagamento;
import br.com.leangua.pagamento.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PagamentoController {
	
	@Autowired
	PagamentoService pagamentoService;

	@Autowired
	Mapper mapper;

	
	@PostMapping("/pagamento")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void efetuaPagamento(@RequestBody PagamentoDto pagamentoDto) {
		Pagamento pagamento = new Pagamento();
		pagamento = mapper.paraPagamento(pagamentoDto);

		pagamentoService.efetuaPagamento(pagamento);
	}
	
	@GetMapping("/pagamentos/{id_cartao}")
	public Iterable<Pagamento> buscarPagamentos(@PathVariable int id_cartao){
		return pagamentoService.buscarPagamentos(id_cartao);
	}

}
