package br.com.mariolemos.Controle_Estoque_Api.dominio;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    @Column(unique = true)
    private String cnpj;
    @OneToMany
    private List<Produto> produtos ;

    public Empresa(){

    }

    public Empresa(Long id, String razaoSocial, String cnpj, List<Produto> produtos) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", produtos=" + produtos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return id == empresa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
