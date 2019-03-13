/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comando190.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Fernado Luiz
 */
public class Conexao {
    String url = "jdbc:mysql://186.202.122.199/clientescmd190";
    String user = "clientescmd190";
    String password = "S@hara775111";
    Connection conexao;
    Statement statement;
    ResultSet resultset;    
}
