package br.com.cozer.erp.validacao;

import br.com.cozer.erp.model.Produto;

public class ProdutoValidacao {

	
	private String produto;
	private String descricao;
	
	public String getProduto() {
		return produto;
	}
	
	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Produto converter() {
		return new Produto(produto, descricao);
	}
	
}
