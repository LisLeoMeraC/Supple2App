/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PedidoDao;
import Models.Pedido;

/**
 *
 * @author churri
 */
public class PedidoController {

    PedidoDao pedao;
    String message;

    public PedidoController() {
        this.message = "";
    }

    public String insertarPedido(String estado, String id_usuario, String total) {
        pedao = new PedidoDao();
        Pedido pe = new Pedido();

        this.message = "Error en los parametros de entrada";

        pe.setEstado(estado);
        pe.setId_usuario(id_usuario);
        pe.setTotal(total);
        
        //validacion de los descuentos
        int descuento = Integer.parseInt(pedao.cantidadVentasPorMes(id_usuario));
        pe.setDescuento(descuento == 0 ? descuento : (descuento > 0 && descuento < 11) ? descuento : 10);

        if (pedao.insertarPedido(pe)) {
            this.message = "procesando...";
        } else {
            this.message = "error de base de datos";
        }
        return this.message;
    }

    public String listarPedidos(String id_usuario) {
        pedao = new PedidoDao();
        return pedao.listarPedidos(id_usuario);
    }
    
    public String listarPedidosCancelados(String id_usuario) {
        pedao = new PedidoDao();
        return pedao.listarPedidosCancelados(id_usuario);
    }
    
    public String listarPedidosTienda(String id_usuario){
        pedao = new PedidoDao();
        Pedido pe = new Pedido();
        
        pe.setId_usuario(id_usuario);
        return pedao.listarPedidosTienda(pe);
    }
    
    public String cancelarPedido (String id_pedido){
        pedao = new PedidoDao();
        if(pedao.cancelarPedido(id_pedido)){
                this.message = "Pedido cancelado correctamente";
        }else{
            this.message = "error";
        }
        return this.message;
    }
    
    public String despacharPedido (String id_pedido){
        pedao = new PedidoDao();
        if(pedao.despacharPedido(id_pedido)){
                this.message = "Pedido despachado correctamente";
        }else{
            this.message = "error";
        }
        return this.message;
    }
    
    public String cantidadDescuento(String id_usuario){
        pedao = new PedidoDao();
        int descuento = Integer.parseInt(pedao.cantidadVentasPorMes(id_usuario));
        int descuento_response = (descuento == 0 ? descuento : (descuento > 0 && descuento < 11) ? descuento : 10);
        return  String.valueOf(descuento_response);
    }
    
}
