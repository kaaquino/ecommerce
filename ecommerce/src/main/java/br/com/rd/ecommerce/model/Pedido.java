package br.com.rd.ecommerce.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pedido")
    private Long codPedido;

    @Column(name = "dt_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPedido;

    @Column(name = "dt_atualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAtualizacao;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "vl_pedido")
    private BigDecimal vlPedido;

    @Column(name = "vl_frete")
    private BigDecimal vlFrete;

    @Column(name = "ds_forma_pagto")
    private String dsFormaPagto;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_pedido")
    private List<ItemPedido> itensPedido;

}
