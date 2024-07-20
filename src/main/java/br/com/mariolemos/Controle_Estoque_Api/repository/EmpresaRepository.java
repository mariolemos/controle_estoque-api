package br.com.mariolemos.Controle_Estoque_Api.repository;


import br.com.mariolemos.Controle_Estoque_Api.dominio.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
