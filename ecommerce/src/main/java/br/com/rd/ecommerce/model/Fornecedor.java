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
@Table(name="tb_fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornecedor;

    @NotNull
    @Column(name="ds_razao_social")
    private String razaoSocial;

    @NotNull
    @Column(name="ds_nome_fantasia")
    private String nomeFantasia;

    @NotNull
    @Column(name="ds_cnpj")
    private String cnpj;

    @Column(name="ds_inscricao_estadual")
    private String inscricaoEstadual;

}