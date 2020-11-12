/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection conectar() {
        Connection con = null;
        final String URL = "jdbc:mysql://localhost:3306/projetodao";
        final String USE = "root";
        final String PASS = "";

        try {

            con = DriverManager.getConnection(URL, USE, PASS);
            return con;

        } catch (Exception e) {
            System.out.println("Não foi possível conectar: " + e);

            return null;
        }
    }

    public static void desconectar(Connection con) {
        try {
            con.close();

        } catch (Exception e) {
             System.out.println("Não foi possível conectar: " + e);

        }

    }

}
