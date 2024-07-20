package br.com.mariolemos.Controle_Estoque_Api.resource;

import br.com.mariolemos.Controle_Estoque_Api.dominio.Empresa;
import br.com.mariolemos.Controle_Estoque_Api.dominio.Produto;
import br.com.mariolemos.Controle_Estoque_Api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {


    @Autowired
    public ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> incluir(@RequestBody Produto prod){
        var prodCreate = produtoService.incluir(prod);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(prodCreate.getId()).toUri();
        return ResponseEntity.created(uri).body(prodCreate);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> listarTodos() {
        List<Produto>obj = produtoService.buscarTodos();
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Produto prod = produtoService.buscarPorId(id);
        return ResponseEntity.ok(prod);
    }
}
