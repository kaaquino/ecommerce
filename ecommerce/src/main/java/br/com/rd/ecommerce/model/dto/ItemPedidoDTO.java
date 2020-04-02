package br.com.rd.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {
    private Long idItem;
    private BigDecimal valor;
    private BigDecimal frete;
    private Integer quantidade;
    private Long codPedido;
    private Long idProduto;
}
