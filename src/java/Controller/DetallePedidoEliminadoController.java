/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.DetallePedidoEliminadoDao;
import Models.DetallePedidoEliminado;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author churri
 */
public class DetallePedidoEliminadoController {
    
    DetallePedidoEliminadoDao dpedao;
    String message;
    
    public DetallePedidoEliminadoController(){
        this.message = "";
    }
    
    public String insertarDetallePedidoEliminado(String cantidad, String precio, String id_producto){
        dpedao = new DetallePedidoEliminadoDao();
        DetallePedidoEliminado detpe = new DetallePedidoEliminado();
        this.message = "Error en los parametros ingresados";
        
        detpe.setCantidad(cantidad);
        detpe.setPrecio(precio);
        detpe.setId_producto(id_producto);
        
        if(dpedao.insertarDetallePedidoEliminado(detpe)){
            this.message = "correcto";
        }else{
            this.message = "error en la base de datos";
        }
        
        return this.message;
    }
    
        public String getProductos(String id_pedido) {
        dpedao = new DetallePedidoEliminadoDao();
        DefaultTableModel table = dpedao.getProductos(id_pedido);
        String detalle = "";
        for (int i = 0; i < table.getRowCount(); i++) {
            detalle += table.getValueAt(i, 4).toString() + ";" + table.getValueAt(i, 1).toString() +";"+table.getValueAt(i, 3).toString();
            if (i < table.getRowCount() - 1) {
                detalle += "/";
            }
        }
        System.out.println(detalle);
        return detalle;
    }

}
