package br.com.rd.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Long codPedido;
    private Date dtPedido;
    private Date dtAtualizacao;
    private BigDecimal frete;
    private BigDecimal totalCompra;
    private String formaPagamento;
    private Long cliente;

    private List<ItemPedidoDTO> itens;
}
