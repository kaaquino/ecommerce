package br.com.rd.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_produto")
    private Long idProduto;

    @NotNull
    @Column(name="ds_titulo")
    private String titulo;

    @NotNull
    @Column(name="ds_fabricante")
    private String fabricante;

    @NotNull
    @Column(name="ds_descricao")
    private String descricao;

    @NotNull
    @Column(name="ds_cor")
    private String cor;

    @NotNull
    @Column(name="nr_valor")
    private BigDecimal valor;

    //1:n
    @ManyToOne
    @JoinColumn(name="cd_categoria")
    private Categoria categoria;

}
