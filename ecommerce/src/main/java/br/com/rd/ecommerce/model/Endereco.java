package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco;

    @NotNull
    @Column(name="nr_telefone")
    private String telefone;

    @NotNull
    @Column(name="ds_cep")
    private String cep;

    @Column(name="ds_logradouro")
    private String logradouro;

    @Column(name="nr_numero_residencia")
    private String numero_residencia;

    @Column(name="ds_complemento")
    private String complemento;

    @Column(name="ts_referencia")
    private String referencia;

    @Column(name="ds_bairro")
    private String bairro;

    @NotNull
    @Column(name="ds_cidade")
    private String cidade;

    @NotNull
    @Column(name="ds_uf")
    private String uf;

    private String id_cliente;
    private String id_fornecedor;

}
