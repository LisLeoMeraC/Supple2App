/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataStatic.Conection;
import Models.Pedido;

/**
 *
 * @author churri
 */
public class PedidoDao {

    Conection conex;
    String sql = "";

    public PedidoDao() {
        conex = new Conection();
    }

    //Se registra el encabezado de un pedido
    public boolean insertarPedido(Pedido pd) {
        try {
            sql = String.format("select*from encabezado_pedido(" + pd.getEstado() + "," + pd.getId_usuario() + "," + pd.getTotal() + "," + pd.getDescuento() + ")");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }

    //Se obtiene las cantidad de ventas por mes de un determinado usuario
    public String cantidadVentasPorMes(String id_usuario) {
        try {
            sql = String.format("select*from cant_ventas_porMes(" + id_usuario + ")");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.fillString(sql);
    }
    
    //Función que se ejecuta cuando el estado de un pedido es cancelado
    public boolean cancelarPedido(Pedido pd) {
        try {
            sql = String.format("select*from cancelar_pedido(" + pd.getId_pedido() + ")");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return conex.modifyBD(sql);
    }
    
    //Se enlista los pedidos hechos por un determinado usuario
    public String listarPedidos(String id_usuario) {
        try {
            sql = "select*from listar_pedidos(" + id_usuario + ")";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.getRecordsInJson(sql);
    }
    
    //Se enlista los pedidos cancelados por un determinado usuario
    public String listarPedidosCancelados(String id_usuario) {
        try {
            sql = "select*from listar_pedidosCancelados(" + id_usuario + ")";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.getRecordsInJson(sql);
    }

    public String listarPedidosTienda(Pedido pd) {
        sql = "select*from listar_pedidos_tienda("+ pd.getId_usuario()+",";
        System.out.println(sql);
        return conex.getRecordsInJson(sql);
    }

    public boolean cancelarPedido(String id_pedido) {
        sql = "select*from eliminar_detalle_pedido("+ id_pedido + ")";
        System.out.println(sql);
        if (conex.modifyBD(sql)) {
            sql = "select*from eliminar_encabezado_pedido("+ id_pedido + ")";
        }
        return conex.modifyBD(sql);
    }

    //Actualiza el estado de un pedido cuando ya es despachado
    public boolean despacharPedido(String id_pedido) {
        sql = "select*from actualizar_estado_pedido("+ id_pedido +")";
        System.out.println(sql);
        return conex.modifyBD(sql);
    }

}
