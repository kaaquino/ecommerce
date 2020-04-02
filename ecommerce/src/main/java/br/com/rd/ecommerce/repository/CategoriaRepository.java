package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByDescricao(String descricao);
}
