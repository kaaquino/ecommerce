package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long idCliente;

    @NotNull
    @Column(name="ds_nome")
    private String nome;

    @NotNull
    @Column(name="ds_cpf")
    private String cpf;

    @NotNull
    @Column(name="ds_email")
    private String email;

    @NotNull
    @Column(name="ds_senha")
    private String senha;

    @NotNull
    @Column(name="ds_nascimento")
    private Date nascimento;

    @Column(name="ds_genero")
    private Character genero;

}
