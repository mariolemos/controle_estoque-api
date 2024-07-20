package br.com.mariolemos.Controle_Estoque_Api.repository;


import br.com.mariolemos.Controle_Estoque_Api.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
