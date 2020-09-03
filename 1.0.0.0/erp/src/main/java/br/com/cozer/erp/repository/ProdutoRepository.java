package br.com.cozer.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cozer.erp.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
