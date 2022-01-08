/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataStatic.Conection;
import Models.PedidoEliminado;

/**
 *
 * @author churri
 */
public class PedidoEliminadoDao {

    Conection conex;
    String sql = "";

    public PedidoEliminadoDao() {
        conex = new Conection();
    }

    public boolean insertarPedidoEliminado(PedidoEliminado pe) {
        try {
            sql = String.format("select*from encabezado_pedido_eliminado (" + pe.getFecha_pedido()
                    + "," + pe.getId_usuario()
                    + "," + pe.getDescuento()
                    + "," + pe.getTotal() + ")");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }
}
