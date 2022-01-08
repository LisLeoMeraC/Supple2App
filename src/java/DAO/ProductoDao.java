/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataStatic.Conection;
import Models.Producto;

/**
 *
 * @author churri
 */
public class ProductoDao {

    Conection conex;
    String sql = "";

    public ProductoDao() {
        conex = new Conection();
    }

    public boolean insertarProducto(Producto pc) {
        try {
            sql = "select * from Insert_Producto(" + pc.getNombre() + "," + pc.getCantidad() + "," + pc.getPrecio() + "," + pc.getId_usuario() + ")";

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }

    /*Se mostrará el listado de todos los productos registrado por un determinado usuario
    ordenado de forma ascedente que cuenten con stock*/
    public String listarProductos(Producto pc) {
        try {
            sql = "select * from listar_Productos(" + pc.getId_usuario() + ")";

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.getRecordsInJson(sql);
    }

    public String listarProductosTienda(Producto pc) {
        try {
            sql = "select * from listar_Productos_Tienda(" + pc.getId_usuario() + ")";

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.getRecordsInJson(sql);
    }

}
