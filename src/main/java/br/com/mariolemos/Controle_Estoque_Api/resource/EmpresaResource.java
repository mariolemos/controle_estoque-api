package br.com.mariolemos.Controle_Estoque_Api.resource;

import br.com.mariolemos.Controle_Estoque_Api.dominio.Empresa;
import br.com.mariolemos.Controle_Estoque_Api.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {

    @Autowired
    public EmpresaService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Empresa> incluir(@RequestBody Empresa emp){
        var empCreate = service.incluir(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(uri).body(empCreate);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Empresa>> buscarTodos() {
        List<Empresa> obj = service.buscarTodos();
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {
        Empresa empresa = service.buscarPorId(id);
        return ResponseEntity.ok(empresa);
    }
}



