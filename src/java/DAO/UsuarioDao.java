/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataStatic.Conection;
import Models.Usuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author churri
 */
public class UsuarioDao {

    Conection conex;
    String sql = "";

    public UsuarioDao() {
        conex = new Conection();
    }

    public boolean insertarUsuario(Usuario us) {
        try {
            sql = String.format("select*from insertar_usuario(" + us.getNombres() + ","
                    + us.getApellidos() + "," + us.getNombre_tienda() + "," + us.getEstado() + "," + us.getTipo_usuario()
                    + "," + us.getUsuario() + "," + us.getContrasenia() + ")");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }

    public boolean habilitar(Usuario us) {
        try {
            sql = "select*from actualizar_estado_usuario(" + us.getId_usuario() + ")";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conex.modifyBD(sql);
    }

    public DefaultTableModel login(String nombre_user, String contrasenia) {
        sql = "select * from usuario where usuario = '" + nombre_user + "' and contrasenia = '" + contrasenia + "'";
        System.out.println(sql);
        return conex.returnRecord(sql);
    }

    public String listarUsuarios() {
        sql = "select * from usuario order by id_usuario";
        return conex.getRecordsInJson(sql);
    }

}
