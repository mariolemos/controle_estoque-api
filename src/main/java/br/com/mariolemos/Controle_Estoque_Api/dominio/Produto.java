package br.com.mariolemos.Controle_Estoque_Api.dominio;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @ManyToOne
    private Categoria categoria;
    private int saldoEstoque;
    @Column(name = "preco")
    private double preco;

    public Produto(Long id, String descricao, Categoria categoria, int saldoEstoque, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.saldoEstoque = saldoEstoque;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(int saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", saldoEstoque=" + saldoEstoque +
                ", preço=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
