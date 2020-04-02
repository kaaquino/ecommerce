package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Produto;
import br.com.rd.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/create-produto")
    public Produto save(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping("/find-produto/list")
    public List<Produto> find(){
        return produtoRepository.findAll();
    }

/*    @GetMapping("/produto/{idProduto}")
    public Produto findById(@PathVariable("idProduto") Long idProduto){
        return produtoRepository.findById(idProduto).get();
    }

    @GetMapping("/produto/{descricao}")
    public List<Produto> findByDescricao(@PathVariable("descricao") String descricao){
        return produtoRepository.findByDescricao(descricao);
    }

    @GetMapping("/produto")
    public Produto findProdutoById(@PathParam("id") Long id){
        return produtoRepository.findById(id).get();
    }*/

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> buscarPorId(@PathParam("id") Long id,
                                                     @PathParam("descricao") String descricao){
        List<Produto> produto = new ArrayList<>();

        if (id!=null && descricao!=null) {
            produto = produtoRepository.findByIdProdutoAndDescricao(id, descricao);
        }else if(id!=null){
            produto.add(produtoRepository.findById(id).get());
        }else if(descricao!=null){
            produto = produtoRepository.findByDescricao(descricao);
        }

        if(produto!=null && produto.size()>0){
            return ResponseEntity.ok().body(produto);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/produto/{id}/{descricao}")
    public List<Produto> findByIdAndDescricao(@PathVariable("id") Long id, @PathVariable("descricao") String descricao){
        return produtoRepository.findByIdProdutoAndDescricao(id, descricao);
    }

    //excluindo por id
    @DeleteMapping("/produto/{id}")
    public void deleteById(@PathVariable("id") Long id){
        produtoRepository.deleteById(id);
    }

    //excluindo por objeto
    /*@DeleteMapping("/produto")
    public void excluirProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }*/

    @PutMapping("/produto")
    public Produto alterar(@RequestBody Produto produto) {
        Produto produtoEntity = produtoRepository.getOne(produto.getIdProduto());
        produtoEntity.setTitulo(produto.getTitulo());
        produtoEntity.setFabricante(produto.getFabricante());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setCor(produto.getCor());
        produtoEntity.setValor(produto.getValor());
        return produtoRepository.save(produtoEntity);

    }

      /*  @PatchMapping
        public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria){
            Categoria categoriaEntity = categoriaRepository.getOne(categoria.getIdCategoria());
            categoriaEntity.setDescricao(categoria.getDescricao());
            Categoria categoriaAtualizada = categoriaRepository.save(categoriaEntity);
            return ResponseEntity.ok().body(categoriaAtualizada);
        }*/
}
