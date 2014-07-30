/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BancoDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alana.sasse
 * Classe que faz a interação com o Banco de Dados
 */
public class InteracaoDAO {
    Connection connection = Conexao.getConexao();
    Statement statement;
    //O método retorna um ResultSet para facilitar operações em laços
    public ResultSet InteracaoDAO(String sql) throws SQLException{
        statement = connection.createStatement();
        ResultSet RS=statement.executeQuery(sql);
        return RS;
    }
    public void Query(String sql)throws SQLException{
        statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
    public void close() throws SQLException{
        connection.close();
    }
    
}
