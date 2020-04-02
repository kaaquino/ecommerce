package br.com.rd.ecommerce.service;

import br.com.rd.ecommerce.model.Categoria;
import br.com.rd.ecommerce.model.dto.CategoriaDTO;
import br.com.rd.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("CategoriaService")
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public ResponseEntity salvar(CategoriaDTO categoriaDTO){
        if(categoriaDTO==null || categoriaDTO.getDescricao()==null){
            return ResponseEntity.badRequest().body(new Exception("Categoria não preenchida"));
        }

        Categoria categoriaEntity = new Categoria();
        categoriaEntity.setDescricao(categoriaDTO.getDescricao());

        Categoria retornoEntity = repository.save(categoriaEntity);
        CategoriaDTO retornoDTO = new CategoriaDTO();
        retornoDTO.setIdCategoria(retornoEntity.getIdCategoria());

        return ResponseEntity.ok().body(retornoDTO);
    }

}
