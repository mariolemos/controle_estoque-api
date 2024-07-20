package br.com.mariolemos.Controle_Estoque_Api.resource;

import br.com.mariolemos.Controle_Estoque_Api.dominio.Categoria;
import br.com.mariolemos.Controle_Estoque_Api.dominio.Empresa;
import br.com.mariolemos.Controle_Estoque_Api.repository.CategoriaRepository;
import br.com.mariolemos.Controle_Estoque_Api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    public CategoriaService categoriaService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Categoria> incluir(@RequestBody Categoria cat) {
        var catCreate = categoriaService.incluir(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(catCreate.getId()).toUri();
        return ResponseEntity.created(uri).body(catCreate);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> listarTodos(){
        List<Categoria> cat = categoriaService.buscarTodos();
        return ResponseEntity.ok().body(cat);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Categoria cat = categoriaService.buscarPorId(id);
        return ResponseEntity.ok(cat);
    }

}
