/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.PedidoEliminadoDao;
import Models.PedidoEliminado;

/**
 * 
 * @author churri
 */
public class PedidoEliminadoController {
    
    PedidoEliminadoDao pedao;
    String message;
    
    public PedidoEliminadoController (){
        this.message = "";
    }
    
    public String insertarPedidoEliminado(String fecha_pedido, String id_usuario, String descuento, String total){
        pedao = new PedidoEliminadoDao();
        PedidoEliminado pe = new PedidoEliminado();
        
        this.message = "Error en los parametros ingresados";
        pe.setFecha_pedido(fecha_pedido);
        pe.setId_usuario(id_usuario);
        pe.setDescuento(descuento);
        pe.setTotal(total);
        
        if(pedao.insertarPedidoEliminado(pe)){
            this.message = "corecto";
        }else{
            this.message = "error de base dedatos";
        }
        
        return this.message;
    }
    
}
