package br.com.mariolemos.Controle_Estoque_Api.dominio;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @OneToMany
    private List<Produto> produtos;

}
