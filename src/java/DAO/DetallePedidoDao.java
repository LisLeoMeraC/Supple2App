/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataStatic.Conection;
import Models.DetallePedido;

/**
 *
 * @author churri
 */
public class DetallePedidoDao {

    Conection conex;
    String sql = "";

    public DetallePedidoDao() {
        conex = new Conection();
    }

    //Se insertar el detalle de un pedido
    public boolean insertarDetallePedido(DetallePedido detp) {
        try {
            sql = String.format("select*from insert_detalle_pedido(" + detp.getId_producto() + "," + detp.getCantidad() + "," + detp.getPrecio() + ")");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }

    
    public boolean cancelarPedido(DetallePedido detp) {
        try {
            sql = String.format("select*from cancelar_pedido(" + detp.getId_pedido() + ")");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }

    //Funcion para disminuir el stock de un producto una vez que se haya efectuado con exito el pedido
    public boolean disminuirStock(DetallePedido detp) {
        try {
            sql = String.format("select*from disminuir_stock(" + detp.getCantidad() + "," + detp.getId_producto() + ")");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }
    
    //Funcion para aumentar el stock de un producto en el caso de pedido de prductos o la cancelacion de un pedido
    public boolean aumentarStock(DetallePedido detp) {
        try {
            sql = String.format("select*from aumentar_stock(" + detp.getCantidad() + "," + detp.getId_producto() + ",");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return conex.modifyBD(sql);
    }

}
