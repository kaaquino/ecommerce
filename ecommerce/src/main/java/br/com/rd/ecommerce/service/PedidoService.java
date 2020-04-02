package br.com.rd.ecommerce.service;

import br.com.rd.ecommerce.model.ItemPedido;
import br.com.rd.ecommerce.model.Pedido;
import br.com.rd.ecommerce.model.dto.ItemPedidoDTO;
import br.com.rd.ecommerce.model.dto.PedidoDTO;
import br.com.rd.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("PedidoService")
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity salvar(PedidoDTO pedidoDTO){
        //validation
        if(pedidoDTO == null || pedidoDTO.getCliente()==null){
            return ResponseEntity.badRequest().body(new Exception("Cliente não informado"));
        }
        if(pedidoDTO.getItens()==null){
            return ResponseEntity.badRequest().body(new Exception("Pedido não contem item"));
        }

        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setDtPedido(pedidoDTO.getDtPedido());
        pedidoEntity.setIdCliente(pedidoDTO.getCliente());
        pedidoEntity.setVlPedido(pedidoDTO.getTotalCompra());
        pedidoEntity.setVlFrete(pedidoDTO.getFrete());
        pedidoEntity.setDsFormaPagto(pedidoDTO.getFormaPagamento());
        pedidoEntity.setDtAtualizacao(new Date());

        List<ItemPedido> listaItens = new ArrayList<>();
        for(ItemPedidoDTO itPedido : pedidoDTO.getItens()){
            ItemPedido it = new ItemPedido();
            it.setVlProduto(itPedido.getValor());
            it.setQuantidade(itPedido.getQuantidade());
            it.setIdProduto(itPedido.getIdProduto());
            it.setVlFrete(itPedido.getFrete());

            listaItens.add(it);
        }
        pedidoEntity.setItensPedido(listaItens);

        Pedido retornoEntity = pedidoRepository.save(pedidoEntity);

        PedidoDTO retornoDTO = new PedidoDTO();
        retornoDTO.setCodPedido(retornoEntity.getCodPedido());

        return ResponseEntity.ok().body(retornoDTO);
    }
}
