package br.com.mariolemos.Controle_Estoque_Api.service;

import br.com.mariolemos.Controle_Estoque_Api.dominio.Empresa;
import br.com.mariolemos.Controle_Estoque_Api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa buscarPorId(Long id){
        return empresaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Empresa> buscarTodos(){
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas;
    }

    public Empresa incluir(Empresa obj){
        obj.setId(null);
        obj.setProdutos(null);
        return empresaRepository.save(obj);
    }

    public Empresa create(Empresa empresaToCreate) {
        if(empresaToCreate.getId() != null && empresaRepository.existsById(empresaToCreate.getId())) {
            throw new IllegalArgumentException("This empresa ID já existe.");
        }
        return empresaRepository.save(empresaToCreate);
    }

}
