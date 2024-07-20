package br.com.mariolemos.Controle_Estoque_Api.service;

import br.com.mariolemos.Controle_Estoque_Api.dominio.Categoria;
import br.com.mariolemos.Controle_Estoque_Api.dominio.Empresa;
import br.com.mariolemos.Controle_Estoque_Api.dominio.Produto;
import br.com.mariolemos.Controle_Estoque_Api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    @Autowired
    public CategoriaRepository categoriaRepository;

    public Categoria incluir(Categoria obj){
        obj.setId(null);
        obj.setProdutos(null);
        return categoriaRepository.save(obj);
    }
    public Categoria buscarPorId(Long id){
        return categoriaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Categoria> buscarTodos(){
        List<Categoria> produto = categoriaRepository.findAll();
        return produto;
    }

}
