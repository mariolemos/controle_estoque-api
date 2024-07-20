package br.com.mariolemos.Controle_Estoque_Api.service;

import br.com.mariolemos.Controle_Estoque_Api.dominio.Empresa;
import br.com.mariolemos.Controle_Estoque_Api.dominio.Produto;
import br.com.mariolemos.Controle_Estoque_Api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public Produto incluir(Produto prod){
        prod.setId(null);
        prod.setCategoria(null);
        return produtoRepository.save(prod);
    }
    public Produto create(Produto produtoToCreate) {
        if(produtoToCreate.getId() != null && produtoRepository.existsById(produtoToCreate.getId())) {
            throw new IllegalArgumentException("This empresa ID já existe.");
        }
        return produtoRepository.save(produtoToCreate);
    }
    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Produto> buscarTodos(){
        List<Produto> produto = produtoRepository.findAll();
        return produto;
    }

}
