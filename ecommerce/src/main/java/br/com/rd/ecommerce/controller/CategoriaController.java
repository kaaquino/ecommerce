package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Categoria;
import br.com.rd.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/create-categoria")
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/find-categoria/list")
    public List<Categoria> find() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/categoria/{idCategoria}")
    public Categoria findById(@PathVariable("idCategoria") Long idCategoria){
        return categoriaRepository.findById(idCategoria).get();
    }

    @GetMapping("/categoria")
    public Categoria findCategoriaById(@PathParam("id") Long id){
        return categoriaRepository.findById(id).get();
    }

    @DeleteMapping("/categoria/{id}")
    public void deleteById(@PathVariable("id") Long id){
        categoriaRepository.deleteById(id);
    }

   @PutMapping("/categoria")
    public Categoria alterar(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = categoriaRepository.getOne(categoria.getIdCategoria());
        categoriaEntity.setDescricao(categoria.getDescricao());
       return categoriaRepository.save(categoriaEntity);

    }

      /*  @PatchMapping
        public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria){
            Categoria categoriaEntity = categoriaRepository.getOne(categoria.getIdCategoria());
            categoriaEntity.setDescricao(categoria.getDescricao());
            Categoria categoriaAtualizada = categoriaRepository.save(categoriaEntity);
            return ResponseEntity.ok().body(categoriaAtualizada);
        }*/

}
