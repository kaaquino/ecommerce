package br.com.rd.ecommerce.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_pedido_item")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_pedido_item")
    private Long codigo;

    @Column(name = "vl_produto")
    private BigDecimal vlProduto;

    @Column(name = "vl_frete")
    private BigDecimal vlFrete;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "cd_produto")
    private Long idProduto;

    @Column(name = "cod_pedido")
    private Integer codPedido;
}
