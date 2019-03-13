/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comando190.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernado Luiz
 */
public class salvarDados extends Conexao{
    public String Cliente(String razao, String nome, String insc, String cnpj, String rua, String bairro, String numero, String comple, String cep, String nomeres, String telefone, String email, String obs){
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(super.url, super.user, super.password);
            String sql = "insert into cliente values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, razao);
            ps.setString(2, nome);
            ps.setString(3, insc);
            ps.setString(4, cnpj);
            ps.setString(5, rua);
            ps.setString(6, bairro);
            ps.setString(7, numero);
            ps.setString(8, comple);
            ps.setString(9, cep);
            ps.setString(10, nomeres);
            ps.setString(11, telefone);
            ps.setString(12, email);
            ps.setString(13, obs);
            ps.execute();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(salvarDados.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("erro");
            return "false";
        }
        System.out.println("sucesso");
        return "true";
    }
}
