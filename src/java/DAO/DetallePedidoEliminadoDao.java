/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataStatic.Conection;
import Models.DetallePedidoEliminado;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author churri
 */
public class DetallePedidoEliminadoDao {

    Conection conex;
    String sql = "";

    public DetallePedidoEliminadoDao() {
        conex = new Conection();
    }

    //Se inserta el detalle de un pedido eliminado
    public boolean insertarDetallePedidoEliminado(DetallePedidoEliminado detpe) {
        try {
            sql = String.format("select*from insertar_detPedidoEliminado(" + detpe.getCantidad() + "," + detpe.getPrecio() + ","
                    + detpe.getId_producto() + ",");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }

    //Se muestra el listado de los productos de un respectivo pedido
    public DefaultTableModel getProductos(String id_pedido) {

        sql = "select * from obtener_productosPedido(" + id_pedido + ")";
        System.out.println(sql);
        return conex.returnRecord(sql);
    }

}
