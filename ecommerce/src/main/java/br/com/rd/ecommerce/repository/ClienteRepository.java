package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
    List<Cliente> findByCpf(String cpf);
    List<Cliente> findByEmail(String email);
    List<Cliente> findBySenha(String senha);
    List<Cliente> findByNascimento(Date nascimento);
    List<Cliente> findByGenero(Character genero);
}
