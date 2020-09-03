package br.com.cozer.erp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cozer.erp.dto.ProdutoDto;
import br.com.cozer.erp.model.Produto;
import br.com.cozer.erp.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping
	public List<ProdutoDto> getProdutos(){
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDto.converte(produtos);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDto> postProduto(@RequestBody @Valid ProdutoDto produtoDto, UriComponentsBuilder uriBuilder) {
		Produto produto = new Produto(produtoDto.getProduto(), produtoDto.getDescricao());
		produtoRepository.save(produto);
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}
	
}
