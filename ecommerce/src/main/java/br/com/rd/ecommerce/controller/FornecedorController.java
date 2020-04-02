package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Fornecedor;
import br.com.rd.ecommerce.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class FornecedorController {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping("/create-fornecedor")
    public Fornecedor save(@RequestBody Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    @GetMapping("/find-fornecedor/list")
    public List<Fornecedor> find(){
        return fornecedorRepository.findAll();
    }

    @GetMapping("/fornecedor/{idFornecedor}")
    public Fornecedor findById(@PathVariable("idFornecedor") Long idFornecedor){
        return fornecedorRepository.findById(idFornecedor).get();
    }

    @GetMapping("/fornecedor")
    public Fornecedor findFornecedorById(@PathParam("id") Long id){
        return fornecedorRepository.findById(id).get();
    }

    @GetMapping("/fornecedor/{razaoSocial}")
    public List<Fornecedor> findByRazaoSocial(@PathVariable("razaoSocial") String razaoSocial){
        return fornecedorRepository.findByRazaoSocial(razaoSocial);
    }

  /*  @GetMapping("/produto/{id}/{descricao}")
    public List<Produto> findByCodAndDescricao(@PathVariable("id") Long id, @PathVariable("descricao") String descricao){
        return produtoRepository.findByCodAndDescricao(id, descricao);
    }*/

    @DeleteMapping("/fornecedor/{id}")
    public void deleteById(@PathVariable("id") Long id){
        fornecedorRepository.deleteById(id);
    }

    @PutMapping("/fornecedor")
    public Fornecedor alterar(@RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorEntity = fornecedorRepository.getOne(fornecedor.getIdFornecedor());
        fornecedorEntity.setRazaoSocial(fornecedor.getRazaoSocial());
        return fornecedorRepository.save(fornecedorEntity);
    }
}
