package br.com.mariolemos.Controle_Estoque_Api.repository;


import br.com.mariolemos.Controle_Estoque_Api.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
