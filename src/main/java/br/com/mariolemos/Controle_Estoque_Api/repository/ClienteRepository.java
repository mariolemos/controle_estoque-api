package br.com.mariolemos.Controle_Estoque_Api.repository;


import br.com.mariolemos.Controle_Estoque_Api.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
