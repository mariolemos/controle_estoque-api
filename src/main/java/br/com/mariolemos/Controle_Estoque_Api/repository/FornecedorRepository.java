package br.com.mariolemos.Controle_Estoque_Api.repository;


import br.com.mariolemos.Controle_Estoque_Api.dominio.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
